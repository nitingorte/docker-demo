package com.cybage.app;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserCrudDockerDemoApplicationTests {

	Calculator calculator = new Calculator();

	@Test
	void addNumbers() {
		//given
		int num1= 20;
		int num2=30;

		//when
		int result = calculator.add(num1, num2);

		//then
		int expected=50;
		assertThat(result).isEqualTo(expected);
	}

	class Calculator{
		int add(int a, int b){
			return a+b;
		}
	}

}
