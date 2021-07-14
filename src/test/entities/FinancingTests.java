package test.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;
import test.factory.FinancingFactory;

public class FinancingTests {

	@Test
	public void entryShouldBeOk() {
		Financing fin = FinancingFactory.createFinancing(100000.0, 2000, 80);
		// 100.000 * 0.2 = 20.000
		// Entrada 20% do valor do montante = 20.000
		// Montante atual = 80.000
		double result = fin.entry();
		Assertions.assertTrue(result == 20000.0);
	}

	@Test
	public void quotaShouldBeEightPercentOfTotalAmountAndDividedByNumberOsMonthsOfFinancing() {
		Financing fin = FinancingFactory.createFinancing(100000.0, 2000, 80);
		// 80% do restante do montante = 100.000 - 20.000 = 80.000
		// prestacao = 80.000/80 = 1.000
		double result = fin.quota();
		Assertions.assertTrue(result == 1000.0);
	}

	// Teste se dados corretos
	@Test
	public void constructorShouldSetValuesWhenValidData() {
		Financing fin = FinancingFactory.createFinancing(100000.0, 2000, 80);
		Assertions.assertTrue(100000 == fin.getTotalAmount());
		Assertions.assertTrue(2000 == fin.getIncome());
		Assertions.assertTrue(80 == fin.getMonths());
	}

	// Teste se dados errados
	@Test
	public void constructorShouldThrowIllegalArugmentExceptionWhenInvalidData() {
		// O valor da prestação não pode ser maior que metade da renda do cliente.
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = FinancingFactory.createFinancing(100000.0, 2000, 79);
		});
	}

	@Test
	public void setTotalAmountShoudlSetValueWhenValidData() {
		Financing fin = FinancingFactory.createFinancing(100000.0, 2000, 80);
		fin.setTotalAmount(90000.0);
		Assertions.assertTrue(90000 == fin.getTotalAmount());
	}

	@Test
	public void setTotalAmountShouldThrowIllegalArgumentExceptionAmountInvalidData() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = FinancingFactory.createFinancing(100000.0, 2000, 80);
			// Pessoa que ganha 2000 , consegue ate 100.000
			fin.setTotalAmount(110000.0); // se setar mais, ela nao vai conseguir
		});
	}

	@Test
	public void setIncomeShoudlSetValueWhenValidData() {
		Financing fin = FinancingFactory.createFinancing(100000.0, 2000, 80);
		fin.setIncome(90000.0);
		Assertions.assertTrue(90000 == fin.getIncome());
	}

	@Test
	public void setIncomeShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = FinancingFactory.createFinancing(100000.0, 2000, 80);
			fin.setIncome(1500.0);
		});
	}

	@Test
	public void setMonthsShoudlSetValueWhenValidData() {
		Financing fin = FinancingFactory.createFinancing(100000.0, 2000, 80);
		fin.setMonths(90);
		Assertions.assertTrue(90 == fin.getMonths());
	}

	@Test
	public void setMonthsShouldThrowIllegalArgumentExceptionWhenInvalidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing fin = FinancingFactory.createFinancing(100000.0, 2000, 80);
			fin.setMonths(79);
		});
	}

}
