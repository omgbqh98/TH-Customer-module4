package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.CustomerServiceImpl;
import service.ICustomerService;

import java.util.List;

@Controller
public class CustomerController {
    ICustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";

    }

    @GetMapping("/customer/create")
    public String showFormCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/customer/save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int) (Math.random() * 10000));
        customerService.add(customer);
        redirectAttributes.addFlashAttribute("success", "add success!");
        return "redirect:/";
    }

    @GetMapping("customer/{id}/edit")
    public String ShowFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }

    @PostMapping("customer/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("success", "update success");
        customerService.edit(customer.getId(), customer);
        return "redirect:/";
    }

    @GetMapping("customer/{id}/delete")
    public String showFormDelete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("customer/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.delete(customer.getId());
        redirectAttributes.addFlashAttribute("success", "delete success!");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}
