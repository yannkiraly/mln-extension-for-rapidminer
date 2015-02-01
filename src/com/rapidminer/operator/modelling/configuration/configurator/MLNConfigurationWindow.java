package com.rapidminer.operator.modelling.configuration.configurator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.rapidminer.gui.tools.ResourceDockKey;
import com.rapidminer.operator.modelling.configuration.MLNGeneralParameter;
import com.rapidminer.operator.modelling.configuration.xmlimportexport.ConfigurationWriter;
import com.vlsolutions.swing.docking.DockKey;
import com.vlsolutions.swing.docking.Dockable;

public class MLNConfigurationWindow extends JPanel implements Dockable, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8384144330803798652L;
	
	private static final int START_X = 0;
	private static final int START_Y = 0;
	private static final int START_WIDTH = 20;
	private static final int START_HEIGHT = 20;

	private final DockKey DOCK_KEY = new ResourceDockKey("mln.config_window");
	private static final String SUBMIT_TEXT = "Update configuration";
	
	private Map<String, JTextField> fieldsForKeys;
	
	public MLNConfigurationWindow() {
		fieldsForKeys = new HashMap<String, JTextField>();
		initializeGUI();
	}
	
	private void addToGridBagPanel(JPanel panel, Component cmp, int anchor, int fill, int gridx, int gridy,
			int gridheight, int gridwidth, float weightx, float weighty, int ipadx, int ipady) {
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = anchor;
		c.fill = fill;
		c.gridx = gridx;
		c.gridy = gridy;
		c.gridheight = gridheight;
		c.gridheight = gridheight;
		c.weightx = weightx;
		c.weighty = weighty;
		c.ipadx = ipadx;
		c.ipady = ipady;
		panel.add(cmp, c);
	}
	
	private void initializeGUI() {
		JTextField field;
		JLabel label;
		JPanel innerPanel = new JPanel();
		setLayout(new BorderLayout());
		add(innerPanel);
		int gridyCounter = 0;
		setBounds(getDimensions());
		innerPanel.setLayout(new GridBagLayout());
		label = new JLabel("MLN Configuration");
		label.setFont(getTitleFont(label, 4));
		addToGridBagPanel(innerPanel, label, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, gridyCounter, 1, 1, 0, 0, 2, 2);
		for (String topic: MLNGeneralParameter.topics()) {
			label = new JLabel(topic);
			label.setFont(getTitleFont(label, 2));
			gridyCounter++;
			addToGridBagPanel(innerPanel, label, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, gridyCounter, 1, 1, 0, 0, 2, 2);
			for (MLNGeneralParameter parameter:  MLNGeneralParameter.forTopic(topic)) {
				label = makeLabel(parameter);
				gridyCounter++;
				addToGridBagPanel(innerPanel, label, GridBagConstraints.WEST, GridBagConstraints.NONE, 0, gridyCounter, 1, 1, 0, 0, 2, 2);
				field = makeTextField(parameter);
				addToGridBagPanel(innerPanel, field, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, 1, gridyCounter, 1, 2, 1, 1, 2, 2);
				fieldsForKeys.put(parameter.getKey(), field);
			}
		}
		gridyCounter++;
		JButton button = new JButton(SUBMIT_TEXT);
		button.addActionListener(this);
		addToGridBagPanel(innerPanel, button, GridBagConstraints.WEST, GridBagConstraints.NONE, 1, gridyCounter, 1, 1, 1, 1, 2, 2);
		add(innerPanel, BorderLayout.CENTER);
	}
	
	private Rectangle getDimensions() {
		return new Rectangle(START_X, START_Y, START_WIDTH, START_HEIGHT);
	}
	
	private Font getTitleFont(JLabel label, int sizeInc) {
		return new Font(label.getFont().getFontName(), Font.BOLD, label.getFont().getSize()+sizeInc);
	}
	
	private JLabel makeLabel(MLNGeneralParameter parameter) {
		return new JLabel(parameter.getKey()+":");
	}
	
	private JTextField makeTextField(MLNGeneralParameter parameter) {
		return new JTextField(parameter.getValue());
	}
	
	@Override
	public Component getComponent() {
		return this;
	}

	@Override
	public DockKey getDockKey() {
		return DOCK_KEY;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (Map.Entry<String, JTextField> entry: fieldsForKeys.entrySet()) {
			MLNGeneralParameter.fromKey(entry.getKey()).setValue(entry.getValue().getText());
		}
		ConfigurationWriter.writeGeneralParameters(MLNGeneralParameter.values());
	}

}
