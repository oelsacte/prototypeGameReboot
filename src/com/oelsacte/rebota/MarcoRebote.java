package com.oelsacte.rebota;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoRebote extends JFrame
{
	public MarcoRebote()
	{
		setSize(this.ANCHURA_PREDETERMINADA, this.ALTURA_PREDETERMINADA);
		setTitle("Rebotes");
		
		lamina = new LaminaPelota();
		add(lamina, BorderLayout.CENTER);
		JPanel laminaBotones = new JPanel();
		
	}
	
	public void ponerBoton(Container c, String titulo, ActionListener oyente)
	{
		JButton boton = new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}
	
	private LaminaPelota lamina;
	public static final int  ANCHURA_PREDETERMINADA = 450;
	public static final int ALTURA_PREDETERMINADA = 350;
	public static final int PASOS = 1000;
	public static final int RETARDO = 3;
}
