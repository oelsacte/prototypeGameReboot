package com.oelsacte.rebota;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoRebote extends JFrame {
	
	private static final Logger LOGGER = Logger.getLogger("MarcoRebote.class");
	
	public MarcoRebote()
	{
		setSize(this.ANCHURA_PREDETERMINADA, this.ALTURA_PREDETERMINADA);
		setTitle("Rebotes");
		
		lamina = new LaminaPelota();
		add(lamina, BorderLayout.CENTER);
		JPanel laminaBotones = new JPanel();
		ponerBoton(laminaBotones, "Comenzar", 
				new ActionListener()
		{
			public void actionPerformed(ActionEvent evento)
			{
				agregarBola();
			}
			
		});
		
		ponerBoton(laminaBotones, "Cerrar", new ActionListener(){
			public void actionPerformed(ActionEvent evento)
			{
				System.exit(0);
			}
		});
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	public void agregarBola()
	{
		try
		{
			Pelota pelota = new Pelota();
			lamina.add(pelota);
			for(int i=1; i <= PASOS; i++)
			{
				pelota.mover(lamina.getBounds());
				lamina.paint(lamina.getGraphics());
				Thread.sleep(RETARDO);
			}
		}
		catch(InterruptedException e)
		{
			LOGGER.severe(e.getMessage());
		}
	}

	public void ponerBoton(Container c, String titulo, ActionListener oyente) {
		JButton boton = new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}

	private LaminaPelota lamina;
	public static final int ANCHURA_PREDETERMINADA = 450;
	public static final int ALTURA_PREDETERMINADA = 350;
	public static final int PASOS = 1000;
	public static final int RETARDO = 3;
}
