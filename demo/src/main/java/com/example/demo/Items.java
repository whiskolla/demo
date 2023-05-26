package com.example.demo;

import eu.hansolo.toolbox.properties.CharProperty;
import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Items {
        private final StringProperty ItN = new SimpleStringProperty();
        private final StringProperty SN = new SimpleStringProperty();
        private final IntegerProperty id = new SimpleIntegerProperty();

    public final int getId(){ return id.get(); }
    public final void setId(int id){this.id.set(id);}
    public String getItN(){ return ItN.get();}
    public final void setItemName(String item_name){this.ItN.set(item_name);}
    public final String getSN(){return SN.get();}
    public final void setSN(String SN){this.SN.set(SN);}
    Items(){};
    Items(final int id, final String SN,final String ItN){
        setId(id);
        setItemName(ItN);
        setSN(SN);
    };
}
