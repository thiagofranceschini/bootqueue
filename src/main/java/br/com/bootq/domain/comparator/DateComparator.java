package br.com.bootq.domain.comparator;

import java.util.Comparator;
import java.util.Date;

public class DateComparator implements Comparator<Date> {

	@Override
	public int compare(Date o1, Date o2) {
		return o2.compareTo(o1);
	}

}