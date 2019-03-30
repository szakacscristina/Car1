package UI;

import Domain.Client;
import Domain.Transaction;
import Service.ClientService;
import Service.CarService;
import Domain.Car;
import Service.TransactionService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;


public class MainController {
    public TableView tblCars;
    public TableColumn colCarId;
    public TableColumn colCarBoughtYear;
    public TableColumn colCarModel;
    public TableColumn colCarKilometers;
    public TableColumn colCarYearOfFabrication;
    public TextField txtCarId;
    public TextField txtCarBoughtYear;
    public TextField txtCarModel;
    public TextField txtCarKilometers;
    public TextField txtCarYearOfFabrication;
    public CheckBox chkInWaranty;
    public Button btnAddCar;
    public TableColumn colCarWarranty;
    public TableView tblClients;
    public TableColumn colClientId;
    public TableColumn colClientLastName;
    public TableColumn colClientFirstName;
    public TableColumn colClientCNP;
    public TableColumn colClientDateOfBirth;
    public TableColumn colDateOfRegistration;
    public TextField txtClientID;
    public TextField txtClientLastName;
    public TextField txtClientFirstName;
    public TextField txtClientCNP;
    public TextField txtClientDateOfBirth;
    public TextField txtClientDateOfRegistration;
    public Button btnAddClient;
    public TableView tblTrans;
    public TableColumn colTranID;
    public TableColumn colTranIdCar;
    public TableColumn colTranIdClient;
    public TableColumn colTranPieceTotal;
    public TableColumn colTranDate;
    public TableColumn colTranTime;
    public TextField txtTranId;
    public TextField txtTranIdCar;
    public TextField txtTranIdClientCard;
    public TextField txtTranPieceTotal;
    public TextField txtTranDate;
    public TextField txtTranTime;
    public Button btnAddTran;
    public Label lblAddClientSection;
    public Label lblAddCarSection;
    public Label lblAddTranSection;
    public Button btnDelCar;
    public Button btnDelTran;
    public Button btnDelClient;
    public Button btnUpdateCar;

    private CarService carService;
    private ClientService clientService;
    private TransactionService transactionService;

    private ObservableList<Car> cars = FXCollections.observableArrayList();
    private ObservableList<Client> clients = FXCollections.observableArrayList();
    private ObservableList<Transaction> trans = FXCollections.observableArrayList();

    public void setServices(CarService carService, ClientService clientService, TransactionService transactionService){
        this.carService = carService;
        this.clientService = clientService;
        this.transactionService = transactionService;
    }

    @FXML
    public void initialize(){
        Platform.runLater(() -> {
            cars.addAll(carService.getAll());
            tblCars.setItems(cars);
            clients.addAll(clientService.getAll());
            tblClients.setItems(clients);
            trans.addAll(transactionService.getAll());
            tblTrans.setItems(trans);
        });
    }


    public void btnAddCarClick(ActionEvent actionEvent){
        try{
            String id = txtCarId.getText();
            String boughtYear = txtCarBoughtYear.getText();
            String model = txtCarModel.getText();
            double kilometers = Double.parseDouble(txtCarKilometers.getText());
            int yearOfFabrication =Integer.parseInt(txtCarYearOfFabrication.getText());
            boolean inWarranty = chkInWaranty.isSelected();

            carService.addOrUpdate(id, boughtYear, model, kilometers, yearOfFabrication, inWarranty);

            cars.clear();
            cars.addAll(carService.getAll());


        } catch (RuntimeException e){
            PopUp.createPopup(e.getMessage());
        }
    }

    public void btnAddClientClick(ActionEvent actionEvent){
        try{
            String id = txtClientID.getText();
            String lastname = txtClientLastName.getText();
            String firstname = txtClientFirstName.getText();
            String CNP = txtClientCNP.getText();
            String dateofbirth = txtClientDateOfBirth.getText();
            String dateofregistration = txtClientDateOfRegistration.getText();

            clientService.addOrUpdate(id, lastname, firstname, CNP, dateofbirth, dateofregistration);

            clients.clear();
            clients.addAll(clientService.getAll());

        } catch (RuntimeException e){
            PopUp.createPopup(e.getMessage());
        }
    }

    public void btnAddTranClick(ActionEvent actionEvent) {
        try {

            String id = txtTranId.getText();
            String idCar = txtTranIdCar.getText();
            String idClientCard = txtTranIdClientCard.getText();
            double piecetotal = Double.parseDouble(txtTranPieceTotal.getText());
            String date = txtTranDate.getText();
            String time = txtTranTime.getText();

            transactionService.addOrUpdate(id, idCar, idClientCard, piecetotal, date, time);

        } catch (RuntimeException e) {
            PopUp.createPopup(e.getMessage());
        }


        trans.clear();
        trans.addAll(transactionService.getAll());
    }

    public void btnDelCarClick(ActionEvent actionEvent) {
        Car selectedCar = (Car) tblCars.getSelectionModel().getSelectedItem();

        if (selectedCar != null){
            try{
                carService.remove(selectedCar.getId());
                cars.clear();
                cars.addAll(carService.getAll());
            } catch (RuntimeException e){
                PopUp.createPopup(e.getMessage());
            }
        }
    }

    public void btnDelClientCardClick(ActionEvent actionEvent) {
        Client selected = (Client) tblClients.getSelectionModel().getSelectedItem();

        if (selected != null){
            try{
                clientService.remove(selected.getId());
                clients.clear();
                clients.addAll(clientService.getAll());
            } catch (RuntimeException e){
                PopUp.createPopup(e.getMessage());
            }
        }
    }

    public void btnDelTranClick(ActionEvent actionEvent) {
        Transaction selected = (Transaction) tblTrans.getSelectionModel().getSelectedItem();

        if (selected != null){
            try{
                transactionService.remove(selected.getId());
                trans.clear();
                trans.addAll(transactionService.getAll());
            } catch (RuntimeException e){
                PopUp.createPopup(e.getMessage());
            }
        }
    }

    public void btnUpdateMedClick(ActionEvent actionEvent) {
        //TODO implement update with separate windows
    }
}