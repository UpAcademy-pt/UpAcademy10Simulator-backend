package simSalProject.models;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name=Margin.GET_ALL_MARGIN_VALUES, query="SELECT m FROM Margin m")
})

public class Margin extends Entity_{
		private static final long serialVersionUID = 1L;
		
		public static final String GET_ALL_MARGIN_VALUES = "getAllMarginValues";
		
		
		public Margin() {}
		
		private int margin_min;
		private int margin_max;


		public int getMargin_min() {
			return margin_min;
		}
		public void setMargin_min(int margin_min) {
			this.margin_min = margin_min;
		}
		public int getMargin_max() {
			return margin_max;
		}
		public void setMargin_max(int margin_max) {
			this.margin_max = margin_max;
		}



		
		
		
}
