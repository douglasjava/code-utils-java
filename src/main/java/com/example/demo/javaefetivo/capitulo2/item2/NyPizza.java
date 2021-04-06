package com.example.demo.javaefetivo.capitulo2.item2;

import java.util.Objects;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class NyPizza extends Pizza {

	private final Size size;

	private NyPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}

	public enum Size {
		SMALL, MEDIUM, LARGE
	}

	public static class Builder extends Pizza.Builder<Builder> {

		private final Size size;

		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		Pizza build() {
			return new NyPizza(this);
		}

		@Override
		Builder self() {
			return this;
		}

	}

}
