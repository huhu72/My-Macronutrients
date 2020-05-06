package Calculator;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import javax.swing.JTextPane;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	private Calculator calc;
	private double weight;
	private int multiplier;
	private String selectedValue;
	private static final double DELTA = 1e-15;
	@Before
	public void setUp() throws Exception {
		calc = new Calculator();
	}

	@Test
	public void testMaintainCalculation(){
		weight = 180;
		multiplier = 15;
		selectedValue = "Maintain";
		calc.calculateMaco(weight,15,selectedValue);
		assertEquals("2700",calc.caloriesTextBox.getText());
		assertEquals("144g",calc.proteinTextBox.getText());
		assertEquals("576",calc.proteinCaloriesTextBox.getText());
		assertEquals("47g",calc.fatTextBox.getText());
		assertEquals("425",calc.fatCaloriesTextBox.getText());
		assertEquals("425g",calc.carbTextBox.getText());
		assertEquals("1699",calc.carbCaloriesTextBox.getText());
		
	}
	@Test
	public void testCutCalculation(){
		weight = 180;
		multiplier = 15;
		selectedValue = "Cut";
		calc.calculateMaco(weight,15,selectedValue);
		assertEquals("2700",calc.caloriesTextBox.getText());
		assertEquals("198g",calc.proteinTextBox.getText());
		assertEquals("792",calc.proteinCaloriesTextBox.getText());
		assertEquals("42g",calc.fatTextBox.getText());
		assertEquals("382",calc.fatCaloriesTextBox.getText());
		assertEquals("382g",calc.carbTextBox.getText());
		assertEquals("1526",calc.carbCaloriesTextBox.getText());
		
	}
	
	@Test
	public void testBulkCalculation(){
		weight = 180;
		multiplier = 15;
		selectedValue = "Bulk";
		calc.calculateMaco(weight,15,selectedValue);
		assertEquals("2700",calc.caloriesTextBox.getText());
		assertEquals("144g",calc.proteinTextBox.getText());
		assertEquals("576",calc.proteinCaloriesTextBox.getText());
		assertEquals("59g",calc.fatTextBox.getText());
		assertEquals("531",calc.fatCaloriesTextBox.getText());
		assertEquals("398g",calc.carbTextBox.getText());
		assertEquals("1593",calc.carbCaloriesTextBox.getText());
		
	}
	@Test 
	public void testSelectMaleRadioBtn(){
		calc.maleRadioButton.doClick();
		assertEquals(15,calc.getMultiplier());
		
	}
	@Test 
	public void testSelectFemaleRadioBtn(){
		calc.femaleRadioButton.doClick();
		assertEquals(12,calc.getMultiplier());
		
	}
	@Test
	public void testOnlyOneRadioBtnCanBeSelected(){
		calc.maleRadioButton.doClick();
		assertTrue(calc.maleRadioButton.isSelected());
		assertFalse(calc.femaleRadioButton.isSelected());
	}
	@Test
	public void testSelectMaintain(){
		calc.comboBox.setSelectedItem("Maintain");
		assertEquals("Maintain",calc.getSelectedValue());
	}
	@Test
	public void testSelectBulk(){
		calc.comboBox.setSelectedItem("Bulk");
		assertEquals("Bulk",calc.getSelectedValue());
	}
	@Test
	public void testSelectCut(){
		calc.comboBox.setSelectedItem("Cut");
		assertEquals("Cut",calc.getSelectedValue());
	}
	@Test
	public void testAddButton(){
		calc.btnAdd.doClick();
		if(!calc.caloriesTextBox.getText().isEmpty()){
			int calories;
			calories = Integer.parseInt(calc.caloriesTextBox.getText().substring(0, calc.caloriesTextBox.getText().length()));
		}
	}
	
}
