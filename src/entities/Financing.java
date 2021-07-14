package entities;

public class Financing {

	private Double totalAmount;
	private Double income;
	private Integer months;

	public Financing() {

	}

	public Financing(Double totalAmount, Double income, Integer months) {
		super();
		this.totalAmount = totalAmount;
		this.income = income;
		this.months = months;
		if (quota() > income / 2.0) {
			throw new IllegalArgumentException("Parcela nao pode ser maior que a metada da renda");
		}
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		if ((totalAmount - entry()) / months > income / 2.0) {
			throw new IllegalArgumentException("Parcela nao pode ser maior que a metada da renda");

		}
		this.totalAmount = totalAmount;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		if (quota() > income / 2.0) {
			throw new IllegalArgumentException("Parcela nao pode ser maior que a metada da renda");
		}
		this.income = income;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		if ((totalAmount - entry()) / months > income / 2.0) {
			throw new IllegalArgumentException("Parcela nao pode ser maior que a metada da renda");
		}
		this.months = months;
	}

	public Double quota() {
		return (totalAmount - entry()) / months;
	}

	public Double entry() {
		return totalAmount * 0.2;
	}
}
