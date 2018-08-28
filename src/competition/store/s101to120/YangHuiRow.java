package competition.store.s101to120;

import java.util.ArrayList;
import java.util.List;

public class YangHuiRow {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();

		for(int i=0;i<=rowIndex;i++){
			list.add(1);
			for(int j=i-1;j>0;j--){
				list.set(j, list.get(j-1)+list.get(j));
			}
		}

		return list;
	}

	public static void main(String[] args) {
		YangHuiRow yangHuiRow =new YangHuiRow();
		yangHuiRow.getRow(3);
	}
}
