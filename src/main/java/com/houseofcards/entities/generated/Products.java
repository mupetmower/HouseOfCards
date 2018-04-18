package com.houseofcards.entities.generated;
// Generated Apr 18, 2018 1:58:05 PM by Hibernate Tools 5.2.8.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name = "products", catalog = "houseofcards")
public class Products implements java.io.Serializable {

	private Integer pkProductId;
	private BigDecimal price;
	private String productName;
	private Integer inventoryQuantity;
	private String thumbnailUri;
	private String productDescription;
	private Set<Discountedproducts> discountedproductses = new HashSet<Discountedproducts>(0);
	private Set<Saleitems> saleitemses = new HashSet<Saleitems>(0);
	private Set<Customercardinventory> customercardinventories = new HashSet<Customercardinventory>(0);
	private Set<Topproducts> topproductses = new HashSet<Topproducts>(0);
	private Set<Mtgcards> mtgcardses = new HashSet<Mtgcards>(0);
	private Set<Productimage> productimages = new HashSet<Productimage>(0);
	private Set<Pokemoncards> pokemoncardses = new HashSet<Pokemoncards>(0);
	private Set<Ygocards> ygocardses = new HashSet<Ygocards>(0);

	public Products() {
	}

	public Products(String productName, String productDescription) {
		this.productName = productName;
		this.productDescription = productDescription;
	}

	public Products(BigDecimal price, String productName, Integer inventoryQuantity, String thumbnailUri,
			String productDescription, Set<Discountedproducts> discountedproductses, Set<Saleitems> saleitemses,
			Set<Customercardinventory> customercardinventories, Set<Topproducts> topproductses,
			Set<Mtgcards> mtgcardses, Set<Productimage> productimages, Set<Pokemoncards> pokemoncardses,
			Set<Ygocards> ygocardses) {
		this.price = price;
		this.productName = productName;
		this.inventoryQuantity = inventoryQuantity;
		this.thumbnailUri = thumbnailUri;
		this.productDescription = productDescription;
		this.discountedproductses = discountedproductses;
		this.saleitemses = saleitemses;
		this.customercardinventories = customercardinventories;
		this.topproductses = topproductses;
		this.mtgcardses = mtgcardses;
		this.productimages = productimages;
		this.pokemoncardses = pokemoncardses;
		this.ygocardses = ygocardses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_ProductID", unique = true, nullable = false)
	public Integer getPkProductId() {
		return this.pkProductId;
	}

	public void setPkProductId(Integer pkProductId) {
		this.pkProductId = pkProductId;
	}

	@Column(name = "Price", precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "ProductName", nullable = false, length = 45)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "InventoryQuantity")
	public Integer getInventoryQuantity() {
		return this.inventoryQuantity;
	}

	public void setInventoryQuantity(Integer inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	@Column(name = "ThumbnailURI", length = 80)
	public String getThumbnailUri() {
		return this.thumbnailUri;
	}

	public void setThumbnailUri(String thumbnailUri) {
		this.thumbnailUri = thumbnailUri;
	}

	@Column(name = "ProductDescription", nullable = false, length = 300)
	public String getProductDescription() {
		return this.productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Discountedproducts> getDiscountedproductses() {
		return this.discountedproductses;
	}

	public void setDiscountedproductses(Set<Discountedproducts> discountedproductses) {
		this.discountedproductses = discountedproductses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Saleitems> getSaleitemses() {
		return this.saleitemses;
	}

	public void setSaleitemses(Set<Saleitems> saleitemses) {
		this.saleitemses = saleitemses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Customercardinventory> getCustomercardinventories() {
		return this.customercardinventories;
	}

	public void setCustomercardinventories(Set<Customercardinventory> customercardinventories) {
		this.customercardinventories = customercardinventories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Topproducts> getTopproductses() {
		return this.topproductses;
	}

	public void setTopproductses(Set<Topproducts> topproductses) {
		this.topproductses = topproductses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Mtgcards> getMtgcardses() {
		return this.mtgcardses;
	}

	public void setMtgcardses(Set<Mtgcards> mtgcardses) {
		this.mtgcardses = mtgcardses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Productimage> getProductimages() {
		return this.productimages;
	}

	public void setProductimages(Set<Productimage> productimages) {
		this.productimages = productimages;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Pokemoncards> getPokemoncardses() {
		return this.pokemoncardses;
	}

	public void setPokemoncardses(Set<Pokemoncards> pokemoncardses) {
		this.pokemoncardses = pokemoncardses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Ygocards> getYgocardses() {
		return this.ygocardses;
	}

	public void setYgocardses(Set<Ygocards> ygocardses) {
		this.ygocardses = ygocardses;
	}

}
