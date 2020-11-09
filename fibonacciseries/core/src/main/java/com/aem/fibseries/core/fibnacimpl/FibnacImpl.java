package com.aem.fibseries.core.fibnacimpl;

import org.osgi.service.component.annotations.Component;

import com.aem.fibseries.core.fibnaciservice.FibnaciSeries;


@Component(immediate = true, service = FibnaciSeries.class)
public class FibnacImpl implements FibnaciSeries {

	int i;
	int result;
	String limit;
	String secondNumber;
	StringBuilder sb;
	String str;

	@Override
	public StringBuilder getFibnaci(String firstNumber, String secondNumber, int limit) {
		// TODO Auto-generated method stub
		try {

			sb = new StringBuilder();
			int firstNumber1 = Integer.parseInt(firstNumber);
			int secondNumber2 = Integer.parseInt(secondNumber);

			String str1 = firstNumber1 + "," + secondNumber2;
			sb.append(str1);
			for (i = 2; i < limit; ++i) {
				result = firstNumber1 + secondNumber2;
				str = "," + result;
				firstNumber1 = secondNumber2;
				secondNumber2 = result;
				sb.append(str);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sb;
	}

}

