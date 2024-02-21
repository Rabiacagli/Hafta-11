package dev.patika.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.apache.bcel.classfile.Code;
@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", columnDefinition = "serial")
    private int  id;


    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private double prc;

    @Column (name = "product_stock")
    private int stock;


    //fetch = FetchType.EAGER :  her şekilde join"le
    @ManyToOne(fetch = FetchType.LAZY) // çoktan aza ilişkisi - bir urunun bır supplier ı var
    @JoinColumn(name = "product_supplier_id" , referencedColumnName = "supplier_id")
    //veri tabanındaki karsılıgı ^         // supplıer tarafındaki karşılıgı ^
    private  Supplier supplier;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id" , referencedColumnName = "category_id")
    private Category category;
}
