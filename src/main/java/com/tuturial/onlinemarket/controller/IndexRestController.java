package com.tuturial.onlinemarket.controller;

import com.tuturial.onlinemarket.controller.dto.OrderDTO;
import com.tuturial.onlinemarket.controller.dto.ProductSearchDTO;
import com.tuturial.onlinemarket.model.entity.*;
import com.tuturial.onlinemarket.model.service.ImageService;
import com.tuturial.onlinemarket.model.service.OrderItemService;
import com.tuturial.onlinemarket.model.service.OrderService;
import com.tuturial.onlinemarket.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class IndexRestController {

    private ProductService productService;
    private ImageService imageService;
    private OrderService orderService;
    private OrderItemService orderItemService;

    @Autowired
    public IndexRestController(ProductService productService, ImageService imageService,OrderService orderService
    , OrderItemService orderItemService) {
        this.productService = productService;
        this.imageService = imageService;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object loadPage(Model model) {
        model.addAttribute("products", this.productService.findAll());
        model.addAttribute("item", new Item());
        model.addAttribute("productSearch", new ProductSearchDTO());
        return "client/index";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public Object getAllProducts(Model model) {
        List<Product> products = this.productService.findAll();
        model.addAttribute("product", new Product());

        model.addAttribute("productList", products);
        model.addAttribute("imageGallery", new ImageGallery());
        return "admin/product";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public Object addProduct(Model model, @ModelAttribute Product product, @RequestParam("imageFile") MultipartFile file
    /*, MultipartFile request
            , /*final @RequestParam("image") MultipartFile file
    ,@RequestPart("image") MultipartFile file
    */) throws IOException {

        System.out.println("----------18-----------------" + product.getImage());
//        this.productService.addNewItem(product);

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        String uploadDir = "product-images";
        //String name = UUID.randomUUID() + "." + FilenameUtils.getExtension(image.getOriginalFilename());
        String name = UUID.randomUUID() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
//
        String uploadDir = "src/main/resources/static/image/product-images/";

        Path copyLocation = Paths
                .get(uploadDir + File.separator + StringUtils.cleanPath(name));
        try {
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
//
        product.setImageAddress(name);
        this.productService.addNewItem(product);
        model.addAttribute("product", new Product());
        return "redirect:/admin/product";
    }

//    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = {"multipart/form-data"})
//    public String saveEmployee(@ModelAttribute("product") Product theEmployee
//            ,@RequestParam("file") MultipartFile file) throws IOException, ParseException {
//
//        // Image
//        System.out.println("/save | File Name : "+file.getName());
//        byte[] imageBytes = file.getBytes();
//
//        try {
//            FileInputStream fileInputStream = new FileInputStream(file.getOriginalFilename());
//            fileInputStream.read(imageBytes);
//            fileInputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        theEmployee.setImage(imageBytes);
//
//
//        // save the employee
//        this.productService.addNewItem(theEmployee);
//
//        // use a redirect to prevent duplicate submissions
//        return "redirect:/product";
//    }


//    @PostMapping("/addProduct")
//    public @ResponseBody
//    ResponseEntity<?> createProduct(@ModelAttribute("product") Product product,
//                                    Model model, HttpServletRequest request
//            , final @RequestParam("file") MultipartFile file) {
//        try {
//            //String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
//            String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
//            String fileName = file.getOriginalFilename();
//            String filePath = Paths.get(uploadDirectory, fileName).toString();
//            if (fileName == null || fileName.contains("..")) {
//                model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
//                return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
//            }
//            String[] names = product.getTitle().split(",");
//            try {
//                File dir = new File(uploadDirectory);
//                if (!dir.exists()) {
//                    dir.mkdirs();
//                }
//                // Save the file locally
//                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
//                stream.write(file.getBytes());
//                stream.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            byte[] imageData = file.getBytes();
////            ImageGallery imageGallery = new ImageGallery();
////            imageGallery.setName(names[0]);
////            imageGallery.setImage(imageData);
////            imageGallery.setPrice(price);
////            imageGallery.setDescription(descriptions[0]);
////            imageGallery.setCreateDate(createDate);
////            imageGalleryService.saveImage(imageGallery);
//            return new ResponseEntity<>("Product Saved With File - " + fileName, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

//    @RequestMapping(value = "/addGallery",method = RequestMethod.GET)
//    public Object showGalleryPage(){
//        return "gallery";
//    }

    @GetMapping("/modals/modal1")
    public String modal1() {
        return "modal1";
    }

    @GetMapping("/modals/modal2")
    public String modal2(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "modal2";
    }

    @RequestMapping(value = "/uploadGallery", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public String uploadGallery(@RequestParam("productId") Long productId, @RequestParam("file") MultipartFile file[]
            , Model model) {
        System.out.println("----------181------------");
        System.out.println("----------181------------" + productId);
        System.out.println("----------185-------------" + file.length);
        Product product = this.productService.findById(productId);
        for (MultipartFile multipartFile : file) {
            if (multipartFile.getSize() > 0) {
                Image image = new Image();
                image.setProduct(product);
                //upload images
                System.out.println("----------187------------" + multipartFile.getOriginalFilename());
                System.out.println("----------188------------" + multipartFile.getSize());
                System.out.println("----------189------------" + multipartFile.getName());

                String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
                String name = UUID.randomUUID() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
//
                String uploadDir = "src/main/resources/static/image/product-images/";

                Path copyLocation = Paths
                        .get(uploadDir + File.separator + StringUtils.cleanPath(name));
                try {
                    Files.copy(multipartFile.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//
                image.setImageAddress(name);
                this.imageService.addNewItem(image);

            }
        }
        model.addAttribute("product", new Product());
        model.addAttribute("productList", this.productService.findAll());
        model.addAttribute("imageGallery", new ImageGallery());
        return "redirect:/product";
    }

    @RequestMapping(value = "/addToCart", method = RequestMethod.POST)
    public Object addToCartSession(@ModelAttribute Item item, Model model, HttpSession httpSession) {

//        List<List<Map<String,Long>>> sessionPre = (List<List<Map<String,Long>>>) httpSession.getAttribute("cart");

        Map<String, Long> productMap = new ConcurrentHashMap<>();//productId,value
        Map<String, Long> productCntMap = new ConcurrentHashMap<>();//cnt,value

        productMap.put("productId", item.getProductId());
        productCntMap.put("cnt", item.getCnt());

        List<List<Map<String, Long>>> cartSession = (List<List<Map<String, Long>>>) httpSession.getAttribute("cart");


//        List<Map<String,Long>> maps = Arrays.asList(productMap,productCntMap);
//        List<List<Map<String,Long>>> cartSession = null;
        if (cartSession != null && cartSession.size() > 0) {
//            cartSession = sessionPre;
//            cartSession.add(maps);

            List<Map<String, Long>> maps1 = new ArrayList<>();
            Map<String, Long> map1 = new HashMap<>();
            map1.put("productId", item.getProductId());
            map1.put("cnt", item.getCnt());
            maps1.add(map1);
            cartSession.add(maps1);
//
        } else {
            cartSession = new ArrayList<>();
            List<Map<String, Long>> maps1 = new ArrayList<>();
            Map<String, Long> map1 = new HashMap<>();
            map1.put("productId", item.getProductId());
            map1.put("cnt", item.getCnt());
            maps1.add(map1);
            cartSession.add(maps1);
        }

        httpSession.setAttribute("cart", cartSession);

        model.addAttribute("products", this.productService.findAll());
        model.addAttribute("item", new Item());
        return "redirect:/";

    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Object loadOrderPage(HttpSession httpSession, Model model) {

//        List<List<Map<String,Long>>> test = new ArrayList<>();
//        List<Map<String,Long>> maps1 = new ArrayList<>();
//        Map<String, Long> map1 = new HashMap<>();
//        Map<String, Long> map2 = new HashMap<>();
//            map1.put("productId",5l);
//            map1.put("cnt",4l);
//            maps1.add(map1);
//        map2.put("productId",6l);
//        map2.put("cnt",6l);
//        maps1.add(map2);
//
//        test.add(maps1);

        List<List<Map<String, Long>>> cart = (List<List<Map<String, Long>>>) httpSession.getAttribute("cart");
        List<OrderDTO> orderList = new ArrayList<>();
        if (cart != null && cart.size() > 0) {
            for (List<Map<String, Long>> maps : cart) {
                for (Map<String, Long> map : maps) {
                    OrderDTO dto = new OrderDTO();
                    Product product = this.productService.findById(map.get("productId"));
                    dto.setTotalDiscountPrice(product.getPriceByDisCount());
                    dto.setTotalPrice(product.getPrice());
                    dto.setCnt(map.get("cnt"));
                    dto.setProductName(product.getTitle());

                    orderList.add(dto);
                }

            }
            model.addAttribute("orders", orderList);
            return "client/order";
        } else {
            return "client/order";
        }

//        List<List<Map<String,Long>>> sessionPre = (List<List<Map<String,Long>>>) httpSession.getAttribute("cart");
//        if(sessionPre != null && sessionPre.size() > 0){
//            for (List<Map<String, Long>> maps : sessionPre) {
//                for (Map<String, Long> map : maps) {
//                    System.out.println("-------------277-------------"+map);
////                    OrderDTO dto = new OrderDTO();
//                    System.out.println(map.get("productId"));
//                    System.out.println(map.get("cnt"));
////                    Product product = this.productService.findById(map.get("productId"));
////                    dto.setCnt(map.get("cnt"));
////                    dto.setProductName(product.getTitle());
////
////                    orderList.add(dto);
//                }
//
//            }
//        }else{
////            orderList.add("اطلاعاتی یاف نشد");
//        }


    }

    @RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
    public Object confirmOrder(HttpSession httpSession) {
        List<List<Map<String, Long>>> cartSession = (List<List<Map<String, Long>>>) httpSession.getAttribute("cart");
        Order order = new Order();
        if(cartSession !=null && cartSession.size() > 0){
            order.setFirstName("hediyeh");
            order.setLastName("ebrahimi");
            order.setStatus(Status.UNPAID);
            order.setTotalAmount(0l);
            order = this.orderService.add(order);

        }
        long total =0;
        for (List<Map<String, Long>> maps : cartSession) {
            for (Map<String, Long> map : maps) {
                OrderItem orderItem = new OrderItem();
                Product product = this.productService.findById(map.get("productId"));
                orderItem.setCnt(map.get("cnt"));
                orderItem.setPrice(product.getPrice());
                orderItem.setDiscountPrice(product.getPriceByDisCount());
                orderItem.setProduct(product);
                orderItem.setOrder(order);
                this.orderItemService.add(orderItem);

                total += orderItem.getCnt() *
                        ((orderItem.getDiscountPrice() != null && orderItem.getDiscountPrice() != 0) ? orderItem.getDiscountPrice() :
                                orderItem.getPrice());

            }

        }

        order.setTotalAmount(total);
        this.orderService.update(order);


        return "redirect:/";
    }

    @RequestMapping(value = "/admin/order",method = RequestMethod.GET)
    public Object loadOrderAdminPanel(Model model){

        model.addAttribute("orderItems",this.orderItemService.findAll());

        return "/admin/orderList";
    }

    @RequestMapping(value = "/product/search",method = RequestMethod.POST)
    public Object searchProducts(@ModelAttribute ProductSearchDTO productSearchDTO ,Model model){

        List<Product> products = this.productService.search(productSearchDTO);
        model.addAttribute("products", products);
        model.addAttribute("item", new Item());
        model.addAttribute("productSearch", new ProductSearchDTO());
        return "client/index";
    }

    @GetMapping(value = "/deleteImage/{imageAddress}/{productId}")
    public @ResponseBody String deleteImage(@PathVariable("imageAddress") String imageAddress,
                              @PathVariable("productId") String productId){

        Product product = this.productService.findById(Long.valueOf(productId));
        Image image = this.imageService.findByProductAndImageAddress(product,imageAddress);
        this.imageService.deleteItem(image);
        return "true";
    }

    @GetMapping(value = "/productDetail/{productId}")
    public Object showProductDetail(@PathVariable("productId") String productId,Model model){
        Product product = this.productService.findById(Long.valueOf(productId));
        model.addAttribute("product",product);
        model.addAttribute("item", new Item());


        return "client/detail";
    }
}
