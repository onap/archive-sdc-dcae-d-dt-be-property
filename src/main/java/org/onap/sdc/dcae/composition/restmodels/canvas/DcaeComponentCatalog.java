package org.onap.sdc.dcae.composition.restmodels.canvas;

import org.onap.sdc.dcae.composition.restmodels.sdc.Resource;

import java.util.List;

public class DcaeComponentCatalog {

	private List<SubCategoryFolder> elements;

	public List<SubCategoryFolder> getElements() {
		return elements;
	}

	public void setElements(List<SubCategoryFolder> elements) {
		this.elements = elements;
	}

	public static class SubCategoryFolder {
		//TODO name and itemId are assigned identical values consider removing one
		private String name;
		private String itemId;
		private List<Resource> items;

		public String getName() {
			return name;
		}

		public String getItemId() {
			return itemId;
		}

		public List<Resource> getItems() {
			return items;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setItemId(String itemId) {
			this.itemId = itemId;
		}

		public void setItems(List<Resource> items) {
			this.items = items;
		}

		public SubCategoryFolder(){}

		public SubCategoryFolder(String subcategory, List<Resource> resources) {
			this.name = subcategory;
			this.itemId = subcategory;
			this.items = resources;
		}
	}
}
