package com.lorenzo.todolist;

import com.lorenzo.todolist.datamodel.Todoitem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Todoitem> todoItems;

    @FXML
    private ListView<Todoitem> todoListView;

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    public void initialize() {
        Todoitem item1= new Todoitem("Mail birthday card", "Buy a 30th birthday card for John",
                LocalDate.of(2018, Month.OCTOBER, 15));
        Todoitem item2= new Todoitem("Doctor's appointment", "See Dr. Smith at 123 Main Street",
                LocalDate.of(2018, Month.OCTOBER, 15));
        Todoitem item3= new Todoitem("Finish project", "Work on the project",
                LocalDate.of(2018, Month.OCTOBER, 15));
        Todoitem item4= new Todoitem("Visit your mother", "try to do this in october",
                LocalDate.of(2018, Month.OCTOBER, 15));
        Todoitem item5= new Todoitem("Work conversation", "Talk about contract",
                LocalDate.of(2018, Month.OCTOBER, 15));

        todoItems = new ArrayList<Todoitem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handleClickListView(){
        Todoitem item=todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
//        System.out.println("The selected item is " + item);
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        itemDetailsTextArea.setText(sb.toString());
    }
}
