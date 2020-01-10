package view;

import javafx.beans.value.ChangeListener;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.input.KeyCode;


public class EditableIntegerTableCell<T, E> extends TableCell<T, Integer> {
    protected TextField textField;
    protected ChangeListener<? super Boolean> changeListener = (obs, ov, nv) -> {
        if (!nv) {
            commitEdit(getParseInt(textField.getText()));
        }
    };

    public EditableIntegerTableCell() {
    }

    @Override
    public void startEdit() {
        if (editableProperty().get()) {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.requestFocus();
            }
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        setText(getItem().toString());
        setGraphic(null);
    }

    @Override
    public void updateItem(Integer item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            if (isEditing()) {
                if (textField != null) {
                    textField.setText(getString());
                    textField.selectAll();
                }
                setText(null);
                setGraphic(textField);
            } else {
                setText(getString());
                setGraphic(null);
            }
        }
    }

    private Integer getParseInt(String str){
        Integer value;
        try {
            value = Integer.parseInt(textField.getText());
        } catch (NumberFormatException e) {
            value = Integer.valueOf(0);
        }
        return value;
    }

    protected void createTextField() {
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        textField.focusedProperty().addListener(changeListener);
        textField.setOnAction(evt -> commitEdit(getParseInt(textField.getText())));

        textField.setOnKeyPressed((ke) -> {
            if (ke.getCode().equals(KeyCode.ESCAPE)) {
                textField.focusedProperty().removeListener(changeListener);
                cancelEdit();
            }
            if (ke.getCode().equals(KeyCode.TAB)) {
                commitEdit(getParseInt(textField.getText()));
            }
        });
    }

    protected String getString() {
        return getItem() == null ? "" : getItem().toString();
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void commitEdit(Integer item) {
        textField.focusedProperty().removeListener(changeListener);
        if (isEditing()) {
            super.commitEdit(item);
        } else {
            final TableView table = getTableView();
            if (table != null) {
                TablePosition position = new TablePosition(getTableView(),
                        getTableRow().getIndex(), getTableColumn());
                CellEditEvent editEvent = new CellEditEvent(table, position,
                        TableColumn.editCommitEvent(), item);
                Event.fireEvent(getTableColumn(), editEvent);
            }
            updateItem(item, false);
            if (table != null) {
                table.edit(-1, null);
            }
        }
    }
}