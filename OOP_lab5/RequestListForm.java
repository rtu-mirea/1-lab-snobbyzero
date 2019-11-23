import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class RequestListForm extends JPanel {
    private JTable requestsTable;

    public RequestListForm() {

        requestsTable = new JTable();
        requestsTable.setRowHeight(30);

        this.add(new JScrollPane(requestsTable));
        requestsTable.setFillsViewportHeight(true);
    }

    public void updateTable(){
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Job");
        model.addColumn("Payment");
        model.addColumn("Hours in week");
        model.addColumn("Type");
        model.addColumn("Requester");
        for (Request request : Main.employeeRequests) {
            String[] row = new String[] {request.getJob(), String.valueOf(request.getPayment()), String.valueOf(request.getHoursinWeek()), "Employee", request.getRequester().getName()};
            model.addRow(row);
        }
        for (Request request : Main.employerRequests) {
            String[] row = new String[] {request.getJob(), String.valueOf(request.getPayment()), String.valueOf(request.getHoursinWeek()), "Employer", request.getRequester().getName()};
            model.addRow(row);
        }
        requestsTable.setModel(model);
        model.fireTableDataChanged();
    }
}
