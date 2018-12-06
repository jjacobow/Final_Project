package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;
import java.awt.Label;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturnRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML
	private Label LbLSEM;
	@FXML
	private Label LbLNTS;
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		LbLSEM.setText("");
		LbLNTS.setText("");
		txtYearsToWork.setText("");;
		txtAnnualReturnWorking.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturnRetired.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		try {
			int iYearsWork = Integer.parseInt(txtYearsToWork.getText());
			double dAnnualReturnWork = Double.parseDouble(txtAnnualReturnWorking.getText());
			int iYearsRetired = Integer.parseInt(txtYearsRetired.getText());
			double dAnnualReturnRetired = Double.parseDouble(txtAnnualReturnRetired.getText());
			double dSSIAmt = Double.parseDouble(txtMonthlySSI.getText());
			double dRequiredIncome = Double.parseDouble(txtRequiredIncome.getText());
			
			Retirement rt = new Retirement();
			rt.setiYearsRetired(iYearsRetired);
			rt.setdAnnualReturnRetired(dAnnualReturnRetired);
			rt.setdMonthlySSI(dSSIAmt);
			rt.setdRequiredIncome(dRequiredIncome);
			rt.setiYearsToWork(iYearsWork);
			rt.setdAnnualReturnWorking(dAnnualReturnWork);
			
			LbLSEM.setText(String.format("$%.2f",rt.AmountToSave()));
			LbLNTS.setText(String.format("$%.2f", rt.TotalAmountSaved()*-1));
			
		
		}catch(NumberFormatException e) {
			LbLSEM.setText("Non Number Input!");
			LbLNTS.setText("Non Number Input!");
		}catch(Exception e) {
			LbLSEM.setText("Error");
			LbLNTS.setText("Error");
		}
		}
		
	}
	
}
