package tn.esprit.rh.achat;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

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

}
