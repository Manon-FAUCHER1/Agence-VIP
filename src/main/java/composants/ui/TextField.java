package composants.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTextField;

import Entities.TypeVehicules;
import Enumerations.StatusVehicules;

/** Champ de type texte pour saisir une information quelconque
 * @author RichardBONNAMY
 *
 */
public class TextField extends Input {
	
	/** Valeur saisie par l'utilisateur */
	private String value;
	
	private StatusVehicules valuestatus;
	
	private List<Selectable> typeVehicules;

	/** Constructeur
	 * @param name nom du champ de saisie
	 * @param label libellé du champ de saisie
	 */
	public TextField(String label, String name) {
		super(label, name);
		this.value="";
		setWidth(200);
		setEditable(true);
	}
	
	/** Constructeur
	 * @param name nom du champ de saisie
	 * @param label libellé du champ de saisie
	 * @param editable indique si le champ est modifiable ou non
	 */
	public TextField(String label, String name, boolean editable) {
		super(label, name);
		this.value="";
		setWidth(200);
		setEditable(editable);
	}
	
	/** Constructeur
	 * @param name nom du champ de saisie
	 * @param label libellé du champ de saisie
	 * @param value valeur du champ de saisie
	 */
	public TextField(String label, String name, String value) {
		super(label, name);
		this.value = value;
		setWidth(200);
		setEditable(true);
	}
	
	/** Constructeur
	 * @param name nom du champ de saisie
	 * @param label libellé du champ de saisie
	 * @param value valeur du champ de saisie
	 * @param editable indique si le champ est modifiable ou non
	 */
	public TextField(String label, String name, String value, boolean editable) {
		super(label, name);
		this.value = value;
		setWidth(200);
		setEditable(editable);
	}
	
	/** Constructeur
	 * @param name nom du champ de saisie
	 * @param label libellé du champ de saisie
	 * @param value valeur du champ de saisie
	 * @param editable indique si le champ est modifiable ou non
	 */
	public TextField(String label, String name, StatusVehicules value, boolean editable) {
		super(label, name);
		this.valuestatus = value;
		setWidth(200);
		setEditable(editable);
	}
	
	/** Constructeur
	 * @param name nom du champ de saisie
	 * @param label libellé du champ de saisie
	 * @param value valeur du champ de saisie
	 * @param editable indique si le champ est modifiable ou non
	 */
	public TextField(String label, String name, List<Selectable> selectable, boolean editable) {
		super(label, name);
		this.typeVehicules = selectable;
		setWidth(200);
		setEditable(editable);
	}

	@Override
	public JComponent convert() {
		JTextField textField = new JTextField();
		textField.setText(value);
		textField.setEditable(isEditable());
		textField.setPreferredSize(new Dimension(getWidth(), 30));
		if (!isEditable()) {
			textField.setBackground(new Color(218, 243, 245));
		}
		return textField;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	@Override
	public void setValue(JComponent component) {
		this.value=((JTextField)component).getText();
	}

	@Override
	public InputType getType() {
		return InputType.TEXTFIELD;
	}


	
}
