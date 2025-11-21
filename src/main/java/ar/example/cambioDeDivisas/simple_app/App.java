package ar.example.cambioDeDivisas.simple_app;

import ar.example.cambioDeDivisas.controller.AppController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AppController appController = new AppController();
    	System.out.println( appController.getExchangeRatesBaseEur() );
    	System.out.println( appController.getExchangeRatesBaseUsd() );
    }
}
