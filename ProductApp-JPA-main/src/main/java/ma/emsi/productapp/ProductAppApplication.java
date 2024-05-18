package ma.emsi.productapp;

import ma.emsi.productapp.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ma.emsi.productapp.entities.Product;


import java.util.List;


@SpringBootApplication
public class ProductAppApplication implements CommandLineRunner {

    @Autowired
   private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(ProductAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



       productRepository.save(new Product(null,"Computer",5000,3));
        productRepository.save(new Product(null,"Printer",2000,5));
        productRepository.save(new Product(null,"Smart Phone",3000,3));




        List<Product> products=productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());
        });



        Product productById=productRepository.findById(Long.valueOf(2)).get();
        System.out.println("--------------------");
        System.out.println(productById.getId());
        System.out.println(productById.getName());
        System.out.println(productById.getPrice());



        List<Product> listProduct=productRepository.findByNameContains("Computer");
        listProduct.forEach(p->{
            System.out.println("--------------------");
            System.out.println(p.toString());
        });

        //Mettre à jour un produit

        Product product=productRepository.findById(Long.valueOf(2)).get();
        if(product!=null)
        {
            product.setQuantity(6);
            productRepository.save(product);
            System.out.println("le produit a été modifié avec succès.");
        }
        else
            System.out.println("le produit est introuvable !!!");


        //supprimer un produit

        Product productToDelete=productRepository.findById(Long.valueOf(3)).get();
       if(productToDelete!=null)
        {
            //productRepository.delete(productToDelete);
            System.out.println("le produit a été supprimé avec succès.");
        }
        else
            System.out.println("le produit est introuvable !!!");










    }
}
