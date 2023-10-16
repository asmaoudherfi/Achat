package tn.esprit.rh.achat.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StockServiceImplTest {

	@InjectMocks
	private StockServiceImpl stockService;

	@Mock
	private StockRepository stockRepository;

	@Test
	public void testAjouterStock() {
		// Création d'un objet de stock fictif
		Stock stock = new Stock();
		stock.setLibelleStock("Stock de test");

		// Configuration du comportement du mock du repository
		when(stockRepository.save(any(Stock.class))).thenReturn(stock);

		// Appel de la méthode à tester
		Stock stockAjouté = stockService.addStock(stock);

		// Vérification du résultat
		assertNotNull(stockAjouté);

		assertEquals("Stock de test", stockAjouté.getLibelleStock());

		// Vérification que la méthode du repository a été appelée avec l'objet Stock
		verify(stockRepository, times(1)).save(stock);
	}
}
