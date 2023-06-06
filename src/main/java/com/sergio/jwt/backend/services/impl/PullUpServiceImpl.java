package com.sergio.jwt.backend.services.impl;

import com.sergio.jwt.backend.entites.tobacoo.Category;
import com.sergio.jwt.backend.entites.tobacoo.Product;
import com.sergio.jwt.backend.repositories.CategoryRepository;
import com.sergio.jwt.backend.repositories.ProductRepository;
import com.sergio.jwt.backend.services.PullUpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PullUpServiceImpl implements PullUpService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public PullUpServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void fillUpDataBase() {
//        Поды	pods
//        Жидкости	liquids
//        Аксессуары accessories
//        Одноразки oneTimeUsing

        Category pods = new Category("pods","Поды");
        Category liquids = new Category("liquids","Жидкости");
        Category accessories = new Category("accessories","Аксессуары");
        Category oneTimeUsing = new Category("oneTimeUsing","Одноразки");

        /*ПОДЫ*/

        Product ijoyCaptainX3 = new Product(
                "IJOY Сaptain X3",
                "https://ufa.smokershop.ru/wa-data/public/shop/products/76/18/1876/images/10793/10793.253@2x.png",
                2100,
                10,
                pods
        );

        Product smoantVikiiPro = new Product(
                "Smoant VIKII PRO Kit",
                "https://ufa.smokershop.ru/wa-data/public/shop/products/14/43/4314/images/22775/22775.253@2x.png",
                1100,
                0,
                pods
        );

        Product vopooDrag4 = new Product(
                "Vopoo Drag 4",
                "https://ufa.smokershop.ru/wa-data/public/shop/products/80/43/4380/images/23725/23725.320.png",
                2000,
                6,
                pods);

        Product lostVapeCentaurusQ200 = new Product(
                "Lost Vape Centaurus Q200",
                "https://ufa.smokershop.ru/wa-data/public/shop/products/52/42/4252/images/22035/22035.253@2x.png",
                3400,
                7,
                pods
        );

        /*ЖИДКОСТИ*/

        Product smokeKitchenPro = new Product(
                "Smoke Kitchen Pro",
                "https://redvape.ru/upload/resize_cache/iblock/f80/210_210_1/f800624d4005df6df4c43cacadc75a6c.png",
                990,
                20,
                liquids
        );

        Product smokeKitchenS360 = new Product(
                "Smoke Kitchen S-360",
                "https://redvape.ru/upload/resize_cache/iblock/ba2/210_210_1/t1xwwqzts1zwp3iw32hbsln8h1ksh9rb.jpg",
                780,
                15,
                liquids
        );

        Product taboo = new Product(
                "Taboo",
                "https://redvape.ru/upload/resize_cache/iblock/adb/210_210_1/bgeeqln5k1zslqmn1ojmnosynea33odm.jpg",
                1100,
                10,
                liquids
        );

        /*ОДНОРАЗКИ*/

        Product urbnZero1500 = new Product(
                "URBN ZERO 1500",
                "https://redvape.ru/upload/resize_cache/iblock/bc9/210_210_1/nzdc81gq7olsqhxmqfkj5qu53i525gaq.jpg",
                1200,
                100,
                oneTimeUsing
        );

        Product elfBarNc1000 = new Product(
                "ELF BAR NC1000",
                "https://redvape.ru/upload/resize_cache/iblock/e3e/210_210_1/mkoy2h71m3hoo14jmpjchb313zg1gpbz.jpg",
                700,
                50,
                oneTimeUsing
        );
        Product elfBar2500 = new Product(
                "ELF BAR 2500",
                "https://redvape.ru/upload/resize_cache/iblock/1e1/210_210_1/a56pt2k6r957hr8de5iuue9c6r23x9pq.jpg",
                850,
                60,
                oneTimeUsing
        );

        /*АКСЕССУАРЫ*/

        Product lgHg2 = new Product(
                "LG HG2 18650 (3000 mAh, 20 A)",
                "https://ufa.smokershop.ru/wa-data/public/shop/products/84/09/984/images/7636/7636.253@2x.png",
                900,
                50,
                accessories
        );

        categoryRepository.saveAll(List.of(pods, liquids,accessories,oneTimeUsing));
        productRepository.saveAll(List.of(ijoyCaptainX3, smoantVikiiPro, vopooDrag4, lostVapeCentaurusQ200,
                smokeKitchenPro, smokeKitchenS360, taboo, urbnZero1500, elfBarNc1000, elfBar2500, lgHg2));


    }
}
