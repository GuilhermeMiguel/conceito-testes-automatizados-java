package br.com.empresa.testes.unitarios;

import java.math.BigDecimal;

public enum DesempenhoFuncionario {

	A_DESEJAR {
		@Override
		public BigDecimal getPorcentagemDeReajuste() {
			return BigDecimal.ZERO;
		}
	},
	BOM {
		@Override
		public BigDecimal getPorcentagemDeReajuste() {
			return BigDecimal.valueOf(0.05);
		}
	},
	OTIMO {
		@Override
		public BigDecimal getPorcentagemDeReajuste() {
			return BigDecimal.valueOf(0.10);
		}
	};
	
	public abstract BigDecimal getPorcentagemDeReajuste();
}
