package tn.esprit.rh.achat;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class StockServiceImplTest {

	@InjectMocks
	private StockServiceImpl stockService;

	@Mock
	private StockRepository stockRepository;
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testaddStock() {
		Stock stock = new Stock();
		// Configurer le mock pour que reglementRepository.save renvoie le Reglement que vous avez créé
		when(stockRepository.save(stock)).thenReturn(stock);
		Stock result = stockService.addStock(stock);
		assertEquals(stock, result);
	}
	@Test
	void testDeleteStock() {
		Long stockId = 1L;
		doNothing().when(stockRepository).deleteById(stockId);
		stockService.deleteStock(stockId);
		verify(stockRepository).deleteById(stockId);
	}
	@Test
	void testRetrieveAllStocks() {
		// Créer une liste fictive de stocks pour simuler la réponse de la base de données
		List<Stock> stocks = new ArrayList<>();
		Stock stock1 = new Stock();
		Stock stock2 = new Stock();
		stocks.add(stock1);
		stocks.add(stock2);

		// Configurer le mock pour que stockRepository.findAll renvoie la liste fictive de stocks
		when(stockRepository.findAll()).thenReturn(stocks);


		List<Stock> result = stockService.retrieveAllStocks();


		verify(stockRepository).findAll();


		assertEquals(stocks, result);
	}
	@Test
	void testUpdateStock() {

	Stock stock = new Stock();


	when(stockRepository.save(stock)).thenReturn(stock);

	// Appelez la méthode updateStock
	Stock result = stockService.updateStock(stock);

	// Vérifiez que la méthode save a été appelée avec l'objet Stock
	verify(stockRepository).save(stock);

	// Vérifiez que l'objet renvoyé par la méthode est égal à l'objet fictif
	assertEquals(stock, result);
}
	@Test
	void testRetrieveStock() {
		Long stockId = 1L; // Remplacez cette valeur par l'identifiant du stock que vous souhaitez récupérer

		// Créez un objet fictif de type Stock pour simuler la réponse de la base de données
		Stock stock = new Stock();

		// Configurez le mock pour que stockRepository.findById renvoie l'objet fictif
		when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));

		// Appelez la méthode retrieveStock
		Stock result = stockService.retrieveStock(stockId);

		// Vérifiez que la méthode findById a été appelée avec le bon stockId
		verify(stockRepository).findById(stockId);

		// Vérifiez que l'objet renvoyé par la méthode est égal à l'objet fictif
		assertEquals(stock, result);
	}

	@Test
	void testRetrieveStatusStock() {
		// Créez une liste fictive de stocks en situation critique
		List<Stock> stocksEnRouge = new ArrayList<>();
		Stock stock1 = new Stock();
		stock1.setLibelleStock("Stock A");
		stock1.setQte(5);
		stock1.setQteMin(10);

		Stock stock2 = new Stock();
		stock2.setLibelleStock("Stock B");
		stock2.setQte(8);
		stock2.setQteMin(15);

		stocksEnRouge.add(stock1);
		stocksEnRouge.add(stock2);

		// Configurez le mock pour que stockRepository.retrieveStatusStock renvoie la liste fictive
		when(stockRepository.retrieveStatusStock()).thenReturn(stocksEnRouge);

		// Appelez la méthode retrieveStatusStock
		String result = stockService.retrieveStatusStock();

		// Vérifiez que la méthode retrieveStatusStock a été appelée
		verify(stockRepository).retrieveStatusStock();

		// Vérifiez que le résultat contient les informations des stocks en situation critique
		assertTrue(result.contains("Stock A") && result.contains("Stock B"));
	}

}
