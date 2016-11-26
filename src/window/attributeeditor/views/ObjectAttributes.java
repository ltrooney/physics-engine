package window.attributeeditor.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import objects.DynamicObject;
import window.Scene;
import constants.Constants;

public class ObjectAttributes extends GenericAttributesView implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel objectPropertiesLabel;
	private JLabel colorLabel;
	private JComboBox<String> colorList;
	private JLabel massLabel;
	private JSpinner massSpinner;
	private JLabel widthLabel;
	private JSpinner widthSpinner;
	private JLabel heightLabel;
	private JSpinner heightSpinner;
	private JLabel xPosLabel;
	private JSpinner xPosSpinner;
	private JLabel yPosLabel;
	private JSpinner yPosSpinner;
	private JLabel currentVelocityLabel;
	private JLabel angleLabel;
	private JSpinner velocitySpinner;
	private JSpinner angleSpinner;
	private JLabel showTrajectoryLabel;
	private JCheckBox showTrajectoryCB;
	private JButton updateProperties;
	
	public static DynamicObject focusedObject;
	
	
	public ObjectAttributes() {
		super();
		setMaximumSize(new Dimension(Constants.EDITOR_WIDTH, Constants.OBJECT_VIEW_HEIGHT));
				
		JPanel titleView = new JPanel();
		titleView.setLayout(new BoxLayout(titleView, BoxLayout.X_AXIS));
		objectPropertiesLabel = new JLabel("Object Properties");
		titleView.add(objectPropertiesLabel);
		add(titleView);
			
		focusedObject = null;
		updateView();
	}
	
	public void updateView() {
		if(focusedObject != null) {
			// color attribute
			JPanel colorView = new JPanel();
			colorView.setLayout(new BoxLayout(colorView, BoxLayout.X_AXIS));
			colorLabel = new JLabel("Color: ");
			colorView.add(colorLabel);
			
			
			String[] colors = {"Black", "Blue", "Red", "Green", "Cyan"};
			colorList = new JComboBox<String>(colors);
			colorList.addActionListener(this);
			colorList.setSelectedIndex(1);
			colorView.add(colorList);
			add(colorView);
					
			// width attribute
			widthLabel = new JLabel("width: ");
			widthSpinner = createSpinner(focusedObject.getWidthInMeters(), 0.1, 20, 0.5);
			JPanel widthView = makeLabelAndSpinnerView(widthLabel, widthSpinner);
			add(widthView);
			
			// height attribute
			heightLabel = new JLabel("height: ");		
			heightSpinner = createSpinner(focusedObject.getHeightInMeters(), 0.1, 20, 0.5);
			JPanel heightView = makeLabelAndSpinnerView(heightLabel, heightSpinner);
			add(heightView);
			
			// mass attribute
			massLabel = new JLabel("mass: ");		
			massSpinner = createSpinner(1.0, 0.1, 50, 1.0);
			JPanel massView = makeLabelAndSpinnerView(massLabel, massSpinner);
			add(massView);
			
			// x position attribute
			xPosLabel = new JLabel("x position: ");		
			xPosSpinner = createSpinner(focusedObject.getXInitial(), 0.0, 100.0, 1.0);
			JPanel xPosView = makeLabelAndSpinnerView(xPosLabel, xPosSpinner);
			add(xPosView);
			
			
			// y position attribute 
			yPosLabel = new JLabel("y position: ");		
			yPosSpinner = createSpinner(focusedObject.getYInitial(), 0.0, 100.0, 1.0);
			JPanel yPosView = makeLabelAndSpinnerView(yPosLabel, yPosSpinner);
			add(yPosView);
			
			
			// velocity attribute
			currentVelocityLabel = new JLabel("Velocity: ");		
			velocitySpinner = createSpinner(focusedObject.getInitialVelocity(), -500.0, 500.0, 1.0);
			JPanel currentVelocityView = makeLabelAndSpinnerView(currentVelocityLabel, velocitySpinner);
			add(currentVelocityView);
			
			// angle attribute
			angleLabel = new JLabel("Angle: ");		
			angleSpinner = createSpinner(focusedObject.getTrajectoryAngle(), -179, 180, 1.0);
			JPanel angleView = makeLabelAndSpinnerView(angleLabel, angleSpinner);
			add(angleView);
			
			// show trajectory check box
			JPanel trajectoryView = new JPanel();
			trajectoryView.setLayout(new BoxLayout(trajectoryView, BoxLayout.X_AXIS));
			showTrajectoryLabel = new JLabel("Show path trajectory");
			showTrajectoryCB = new JCheckBox();
			showTrajectoryCB.setSelected(focusedObject.shouldShowPath());
			showTrajectoryCB.addActionListener(this);
			
			trajectoryView.add(showTrajectoryLabel);
			trajectoryView.add(showTrajectoryCB);
			add(trajectoryView);
			
			JPanel updatePropertiesView = new JPanel();
			updateProperties = new JButton("Update Properties");
			updateProperties.addActionListener(this);
			updatePropertiesView.add(updateProperties);
			add(updatePropertiesView);
		} else {
			JPanel noObjectView = new JPanel();
			noObjectView.setPreferredSize(new Dimension(Constants.EDITOR_WIDTH, 30));
			JLabel noObjectLabel = new JLabel("(No object selected)");
			noObjectView.add(noObjectLabel);
			add(noObjectView);
		}
	}
	
	public static void setFocusedObject(DynamicObject obj) {
		focusedObject = obj;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == updateProperties && focusedObject != null) { 
			focusedObject.setColorString(colorList.getSelectedItem().toString());
			focusedObject.setDimension((double)widthSpinner.getValue(), (double)heightSpinner.getValue());
			focusedObject.placeAt((double)xPosSpinner.getValue(), (double)yPosSpinner.getValue());
			focusedObject.setInitialVelocity((double)velocitySpinner.getValue());
			focusedObject.setTrajectoryAngleInDegrees((double) angleSpinner.getValue());
			focusedObject.showPathTrajectory(showTrajectoryCB.isSelected());
			Scene.reset();
		}
	}
	
}
