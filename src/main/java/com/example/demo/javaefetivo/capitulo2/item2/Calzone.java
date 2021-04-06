package com.example.demo.javaefetivo.capitulo2.item2;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Calzone extends Pizza {

	private final boolean sauceInside;

	Calzone(Builder builder) {
		super(builder);
		sauceInside = builder.sauceInside;
	}

	public static class Builder extends Pizza.Builder<Builder> {
		private boolean sauceInside = false;

		public Builder sauceInside() {
			sauceInside = true;
			return this;
		}

		@Override
		Pizza build() {
			return new Calzone(this);
		}

		@Override
		Builder self() {
			return this;
		}

	}
}
