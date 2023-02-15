package com.example.datatable12;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import java.io.Serializable;
import java.util.*;

@Named("tblSrc")
@ViewScoped
public class TableSource implements Serializable {

    private MyObject selectedRow;
    private List<MyObject> selectedMainRows;
    private List<MyObject> selectedSubRows;
    private List<MyObject> mainList;
    private List<MyObject> list0;
    private List<MyObject> list1;
    private List<MyObject> list2;
    private List<MyObject> list3;
    private List<MyObject> list4;
    private List<List<MyObject>> subArr;
    private FacesMessage msg;

    @PostConstruct
    public void init() {
        mainList = generateData("S", 5);
        list0 = generateData("A", 5);
        list1 = generateData("B", 5);
        list2 = generateData("C", 5);
        list3 = generateData("D", 5);
        list4 = generateData("E", 5);
        subArr = Arrays.asList(list0, list1, list2, list3, list4);
        System.out.println("Init .....");
    }

    public void onRowSelect(SelectEvent<MyObject> event) {
        if (!Objects.equals(event.getObject(), null))
            msg = new FacesMessage("MyObject Selected", String.valueOf(event.getObject().toString()));
        System.out.println("msg = " + msg.getDetail());
        DataTable dt = (DataTable) event.getSource();
        var xx = dt.getSelectedRowKeys();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public void onRowUnselect(UnselectEvent<MyObject> event) {
        if (Objects.equals(event.getObject(), null)) return;
        FacesMessage msg = new FacesMessage("Product Unselected", String.valueOf(event.getObject().toString()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<MyObject> getSubRows(MyObject mo) {
        int ix = Integer.valueOf(mo.getStr().substring(1));
        return subArr.get(ix);
    }
    public List<MyObject> getMainList() {
        return mainList;
    }

    public MyObject getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(MyObject selectedRow) {
        this.selectedRow = selectedRow;
    }

    public List<MyObject> getSelectedMainRows() {
        return selectedMainRows;
    }

    public void setSelectedMainRows(List<MyObject> selectedMainRows) {
        this.selectedMainRows = selectedMainRows;
    }

    public List<MyObject> getSelectedSubRows() {
        return selectedSubRows;
    }

    public void setSelectedSubRows(List<MyObject> selectedSubRows) {
        this.selectedSubRows = selectedSubRows;
    }

    private List<MyObject> generateData(String data, int count) {
        List<MyObject> ret = new ArrayList<>(count);
        for (int i=0; i<count; i++)
            ret.add(new MyObject(UUID.randomUUID(), data+i));
        return ret;
    }
}
