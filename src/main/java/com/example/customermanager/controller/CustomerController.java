package com.example.customermanager.controller;


import lombok.extern.slf4j.XSlf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.customermanager.model.CustomerEntity;
import com.example.customermanager.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
//@XSlf4j
public class CustomerController {
    @Autowired
    private CustomerService customerService;

//    private  static final Logger logger = (Logger) LoggerFactory.getLogger(CustomerController.class);

//    @Autowired
//    private  CustomerEntity customerEntity;

    @RequestMapping(value = {"/", "/customer-list"})
    public String listCustomer(Model model) {
        model.addAttribute("listCustomer", customerService.findAll());
//        logger.info("hien thi danh sach nhé !");
        return "customer-list";

    }

    @RequestMapping("/customer-save")
    //map cái url- castomer save với lại method insertCustomer. Mà trong cái url có 2 value thì cần xem xét để đặt value
    public String insertCustomer(Model model) {
        model.addAttribute("customer", new CustomerEntity());
        List<String> listFavorite = new ArrayList<String>();
        listFavorite.add("Swimming");
        listFavorite.add("Listening music");
        listFavorite.add("Walking");
        listFavorite.add("Watching movie");
        listFavorite.add("Reading comic");
        model.addAttribute("listFavorite", listFavorite);
        List<String> listPosition = new ArrayList<String>();
        listPosition.add("Developer");
        listPosition.add("Designer");
        listPosition.add("Tester");
        listPosition.add("QA");
        model.addAttribute("listFavorite", listFavorite);
        model.addAttribute("listPosition", listPosition);
        return "customer-save";
    }

    @RequestMapping("/customer-view/{id}")
    public String viewCustomer(@PathVariable int id, Model model) {
        CustomerEntity customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer-view";
    }

    @RequestMapping("/customer-update/{id}")
    public String updateCustomer(@PathVariable int id, Model model) {
        CustomerEntity customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("customer", new CustomerEntity());
        List<String> listFavorite = new ArrayList<String>();
        listFavorite.add("Swimming");
        listFavorite.add("Listening music");
        listFavorite.add("Walking");
        listFavorite.add("Watching movie");
        listFavorite.add("Reading comic");
        model.addAttribute("listFavorite", listFavorite);
        List<String> listPosition = new ArrayList<String>();
        listPosition.add("Developer");
        listPosition.add("Designer");
        listPosition.add("Tester");
        listPosition.add("QA");
        model.addAttribute("listFavorite", listFavorite);
        model.addAttribute("listPosition", listPosition);
        return "customer-update";
    }

        @RequestMapping("/saveCustomer")
        public String doSaveCustomer (@ModelAttribute("Customer") CustomerEntity customer, Model model){
            customerService.save(customer);
            model.addAttribute("listCustomer", customerService.findAll());
            return "customer-list";
        }

        @RequestMapping("/updateCustomer")
        public String doUpdateCustomer (@ModelAttribute("Customer") CustomerEntity customer, Model model){
            customerService.update(customer);
            model.addAttribute("listCustomer", customerService.findAll());
            model.addAttribute("customer", new CustomerEntity());
            List<String> listFavorite = new ArrayList<String>();
            listFavorite.add("Swimming");
            listFavorite.add("Listening music");
            listFavorite.add("Walking");
            listFavorite.add("Watching movie");
            listFavorite.add("Reading comic");
            model.addAttribute("listFavorite", listFavorite);
            List<String> listPosition = new ArrayList<String>();
            listPosition.add("Developer");
            listPosition.add("Designer");
            listPosition.add("Tester");
            listPosition.add("QA");
            model.addAttribute("listFavorite", listFavorite);
            model.addAttribute("listPosition", listPosition);
            return "redirect:/customer-list";// model không thể chia sẻ giữa 2 url là updateCustomer và customer-List
        }

        @RequestMapping("/customerDelete/{id}")
        public String doDeleteCustomer ( @PathVariable int id, Model model){
            customerService.delete(id);
            model.addAttribute("listCustomer", customerService.findAll());
            return "redirect:/customer-list";//forward xảy ra trên cùng 1 request nên dữ liệu trong model dc tạp ra bởi hàm này có
            //thể đợc sahre cho url customer-list
        }
    }


