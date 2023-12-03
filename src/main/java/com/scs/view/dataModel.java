package com.scs.view;


import javax.swing.table.AbstractTableModel;
import java.util.Vector;
public class dataModel extends AbstractTableModel{

    //rowData用来存放行数据
    //columnNames存放列名
    Vector rowData, columnNames;



    //得到共有多少列
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return this.columnNames.size();
        //	return 0;
    }
    //得到共有多少行
    public int getRowCount() {
        // TODO Auto-generated method stub
        return this.rowData.size();
        //return 0;
    }
    //得到某行某列的数据
    public Object getValueAt(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return ((Vector) this.rowData.get(arg0)).get(arg1);    // arg0表示行 arg1 表示列
        //	return null;
    }

    //重写方法 getColumnName
    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return (String)this.columnNames.get(column);
    }

}
