package Calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

public class Calculator implements ActionListener {
	private JFrame frame = new JFrame();
	JComboBox<String> comboBox = new JComboBox<>();
	private JTextPane weightTextBox = new JTextPane();
	 JTextPane carbTextBox = new JTextPane();
	JTextPane proteinTextBox = new JTextPane();
	JTextPane caloriesTextBox = new JTextPane();
	 JTextPane fatTextBox = new JTextPane();
	JTextPane proteinCaloriesTextBox = new JTextPane();
	 JTextPane carbCaloriesTextBox = new JTextPane();
	 JTextPane fatCaloriesTextBox = new JTextPane();
	private JButton CalculateBtn = new JButton("Calculate");
    JButton btnSubtract = new JButton("Subtract");
	private JButton btnSave = new JButton("Save");
	JButton btnAdd = new JButton("Add");
	JRadioButton maleRadioButton = new JRadioButton("Male");
	JRadioButton femaleRadioButton = new JRadioButton("Female");
	private int multiplier;
	private double weight;
	private String selectionValue = "Maintain";
	
	public static void main(String[] args) {
		Calculator myFrame = new Calculator();
		myFrame.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.frame.setLocationRelativeTo(null);
		myFrame.frame.setVisible(true);
		
	}
	
	Calculator(){

			frame.setBounds(100, 100, 313, 180);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			JLabel lblNewLabel = new JLabel("Enter Weight:");
			lblNewLabel.setBounds(6, 10, 88, 16);
			frame.getContentPane().add(lblNewLabel);

			JLabel lblCalories = new JLabel("Calories:");
			lblCalories.setBounds(33, 30, 61, 16);
			frame.getContentPane().add(lblCalories);

			JLabel lblProtein = new JLabel("Protein:");
			lblProtein.setBounds(40, 50, 61, 16);
			frame.getContentPane().add(lblProtein);

			JLabel lblCarb = new JLabel("Carb:");
			lblCarb.setBounds(55, 70, 61, 16);
			frame.getContentPane().add(lblCarb);

			JLabel lblFat = new JLabel("Fat:");
			lblFat.setBounds(65, 90, 61, 16);
			frame.getContentPane().add(lblFat);

			weightTextBox.setBounds(93, 10, 43, 16);
			weightTextBox.setEditable(true);
			frame.getContentPane().add(weightTextBox);

			carbTextBox.setBounds(93, 70, 43, 16);
			carbTextBox.setEditable(false);
			frame.getContentPane().add(carbTextBox);

			proteinTextBox.setBounds(93, 50, 43, 16);
			proteinTextBox.setEditable(false);
			frame.getContentPane().add(proteinTextBox);

			caloriesTextBox.setBounds(93, 30, 43, 16);
			caloriesTextBox.setEditable(false);
			frame.getContentPane().add(caloriesTextBox);

			comboBox.setBounds(148, 5, 108, 27);
			comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Maintain", "Cut", "Bulk" }));
			comboBox.setSelectedIndex(0);
			comboBox.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if(comboBox.getSelectedItem().equals("Bulk")){
						setSelectedValue("Bulk");
					}
					else if(comboBox.getSelectedItem().equals("Cut")){
						setSelectedValue("Cut");
					}
					else{
						setSelectedValue("Maintain");
					}
				}
			});
			frame.getContentPane().add(comboBox);

			fatTextBox.setBounds(93, 90, 43, 16);
			fatTextBox.setEditable(false);
			frame.getContentPane().add(fatTextBox);

			JLabel lblProteinCalories = new JLabel("Protein Calories:");
			lblProteinCalories.setBounds(148, 50, 105, 16);
			frame.getContentPane().add(lblProteinCalories);

			JLabel lblCarbCalories = new JLabel("Carb Calories:");
			lblCarbCalories.setBounds(164, 70, 88, 16);
			frame.getContentPane().add(lblCarbCalories);

			JLabel lblFatCalories = new JLabel("Fat Calories:");
			lblFatCalories.setBounds(174, 90, 78, 16);
			frame.getContentPane().add(lblFatCalories);

			proteinCaloriesTextBox.setBounds(262, 50, 43, 16);
			proteinCaloriesTextBox.setEditable(false);
			frame.getContentPane().add(proteinCaloriesTextBox);

			carbCaloriesTextBox.setBounds(262, 70, 43, 16);
			carbCaloriesTextBox.setEditable(false);
			frame.getContentPane().add(carbCaloriesTextBox);

			fatCaloriesTextBox.setBounds(262, 90, 43, 16);
			fatCaloriesTextBox.setEditable(false);
			frame.getContentPane().add(fatCaloriesTextBox);

			CalculateBtn.setBounds(33, 130, 117, 29);
			frame.getContentPane().add(CalculateBtn);
			CalculateBtn.addActionListener(this);
			
			maleRadioButton.setBounds(148, 30, 61, 23);
			maleRadioButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {setMultiplier(15);}
				
			});
			frame.getContentPane().add(maleRadioButton);
			
			femaleRadioButton.setBounds(223, 30, 78, 23);
			femaleRadioButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {setMultiplier(12);}
				
			});
			frame.getContentPane().add(femaleRadioButton);
			// The Group, make sure only one button is selected at a time in the
			// group
			ButtonGroup editableGroup = new ButtonGroup();
			editableGroup.add(femaleRadioButton);
			editableGroup.add(maleRadioButton);

			/*btnSubtract.setBounds(188, 110, 117, 29);
			//btnSubtract.addActionListener(this);
			frame.getContentPane().add(btnSubtract);

			btnSave.setBounds(188, 130, 117, 29);
			//btnSave.addActionListener(this);
			frame.getContentPane().add(btnSave);

			btnAdd.setBounds(33, 110, 117, 29);
			//btnAdd.addActionListener(this);
			frame.getContentPane().add(btnAdd);

			
		*/

	}
	public void actionPerformed(ActionEvent e) {
		 if(weightTextBox.getText().isEmpty()){
			JOptionPane.showMessageDialog(frame, "Please enter your weight");
		}
		 else{
			 weight = Double.parseDouble(weightTextBox.getText());
		 }
		 
		if(e.getSource() == CalculateBtn){
			if(!weightTextBox.getText().isEmpty() &&!maleRadioButton.isSelected() && !femaleRadioButton.isSelected()){
				JOptionPane.showMessageDialog(frame, "Please select a gender");
			}
			else{
			calculateMaco(weight,multiplier,selectionValue);
			}
		}
	}

	public void calculateMaco(double weight, int multiplier, String selectedValue) {
		double proteinPercentage;
		double fatPercentage;
		int calories, carbs,proteins,fats,carbCalories,proteinCalories, fatCalories;
		
		calories = (int) (weight * multiplier);
		this.caloriesTextBox.setText(Integer.toString(calories));
		if(selectedValue.equals("Cut")){
			proteinPercentage = 1.1;
			fatPercentage = .2;
		}
		else if(selectedValue.equals("Bulk")){
			proteinPercentage = .8;
			fatPercentage = .25;
		}
		else{
			proteinPercentage = .8;
			fatPercentage = .2;
		}
		
		proteins = (int) Math.round((weight * proteinPercentage));
		proteinCalories = proteins * 4;
		fatCalories = (int) Math.round((calories - proteinCalories) * fatPercentage);
		fats = fatCalories / 9;
		carbCalories = calories - proteinCalories- fatCalories;
		carbs = (int)Math.round(carbCalories/4.00);
		setText(calories,carbs,carbCalories,proteins,proteinCalories,fats,fatCalories);
		
	}

	private void setText(int calories, int carbs, int carbCalories, int proteins, int proteinCalories, int fats,
			int fatCalories) {
		this.proteinTextBox.setText(Integer.toString(proteins) + "g");
		this.caloriesTextBox.setText(Integer.toString(calories));
		this.fatTextBox.setText(Integer.toString(fats) + "g");
		this.carbTextBox.setText(Integer.toString(carbs) + "g");
		this.fatCaloriesTextBox.setText(Integer.toString(fatCalories));
		this.proteinCaloriesTextBox.setText(Integer.toString(proteinCalories));
		this.carbCaloriesTextBox.setText(Integer.toString(carbCalories));

	}

	public int getMultiplier() {
		return this.multiplier;
	}
	public void setMultiplier(int value){this.multiplier = value;}

	public String getSelectedValue() {return this.selectionValue;}
	public void setSelectedValue(String value) { this.selectionValue = value ;}
	
	
	


	
	

}
