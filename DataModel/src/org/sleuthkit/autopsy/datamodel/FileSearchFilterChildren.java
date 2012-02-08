/*
 * Autopsy Forensic Browser
 * 
 * Copyright 2011 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.datamodel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.sleuthkit.datamodel.Directory;
import org.sleuthkit.datamodel.DisplayableItem;
import org.sleuthkit.datamodel.DisplayableItemVisitor;
import org.sleuthkit.datamodel.File;
import org.sleuthkit.datamodel.FsContent;
import org.sleuthkit.datamodel.SearchFilters.FileSearchFilter;
import org.sleuthkit.datamodel.SleuthkitCase;

/**
 *
 * @author dfickling
 */
class FileSearchFilterChildren extends ChildFactory<DisplayableItem> {
    
    SleuthkitCase skCase;
    FileSearchFilter filter;

    public FileSearchFilterChildren(FileSearchFilter filter, SleuthkitCase skCase) {
        this.filter = filter;
        this.skCase = skCase;
    }

    @Override
    protected boolean createKeys(List<DisplayableItem> list) {
        list.addAll(runQuery());
        return true;
    }
    
    private String createQuery(){
        String query = "select * from tsk_files where 0";
        for(String s : filter.getFilter()){
            query += " or name like '%" + s + "'";
        }
        return query;
    }
    
    private List<? extends DisplayableItem> runQuery(){
        List<? extends DisplayableItem> list = new ArrayList<FsContent>();
        try {
            ResultSet rs = skCase.runQuery(createQuery());
            return skCase.resultSetToFsContents(rs);
        } catch (SQLException ex) {
            Logger.getLogger(FileSearchFilterChildren.class.getName())
                    .log(Level.INFO, "Couldn't get search results", ex);
        }
        return list;
        
    }
    
    @Override
    protected Node createNodeForKey(DisplayableItem key){
        return key.accept(new DisplayableItemVisitor.Default<AbstractNode>(){
            
            @Override
            public FileNode visit(File f){
                return new FileNode(f);
            }
            
            @Override
            public DirectoryNode visit(Directory d) {
                return new DirectoryNode(d);
            }

            @Override
            protected AbstractNode defaultVisit(DisplayableItem di) {
                throw new UnsupportedOperationException("Not supported for this type of Displayable Item: " + di.toString());
            }
            
        });
    }
    
}