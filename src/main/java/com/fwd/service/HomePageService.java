package com.fwd.service;

import com.fwd.domain.Menu;
import com.fwd.domain.Pages;
import com.fwd.domain.Profile;
import com.fwd.domain.Testimonial;
import com.fwd.repository.PageRepository;
import com.fwd.repository.TestimonialRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fwd.repository.MenuRepository;
import com.fwd.repository.ProfileRepository;

@Service
public class HomePageService {

    @Autowired
    MenuRepository menuRepository;
    
    @Autowired
    PageRepository pageRepository;
    
    @Autowired
    TestimonialRepository testimonialRepository;
    
    @Autowired
    ProfileRepository settingRepository;

    public List<Menu> getMainCarouselBar() {
        Date now = new Date();
        List<Menu> menu = menuRepository.findTop5ByTypeAndActiveAndStartTimeLessThanAndEndTimeGreaterThanOrderByOrdersAsc(Menu.CAROUSEL_TYPE, true, now, now);
        
        return menu;
    }
    
    public List<Menu> getMainStaticRight() {
        Date now = new Date();
        List<Menu> menu = menuRepository.findTop3ByTypeAndActiveAndStartTimeLessThanAndEndTimeGreaterThanOrderByOrdersAsc(Menu.STATIC_RIGHT_TYPE, true, now, now);
        
        return menu;
    }
    
    public List<Menu> getMenu(String menuType) {
        Date now = new Date();
        List<Menu> menu = menuRepository.findByTypeAndActiveAndStartTimeLessThanAndEndTimeGreaterThanOrderByOrdersAsc(menuType, true, now, now);
        
        return menu;
    }
    
    public List<Testimonial> getTestimonial() {
        List<Testimonial> testimonials = testimonialRepository.findTop8ByApprovalOrPrimeOrderByDatetimeDesc(true, true);
        
        return testimonials;
    }
    
    public List<Pages> getCelebrate() {
        List<Pages> pages = pageRepository.findTop1ByTypeAndActiveOrderByOrdersAsc(Pages.CELEBRATE_LIVING_TYPE, true);
        
        return pages;
    }
    
    public List<Profile> getProfile() {
        List<Profile> setting = settingRepository.findTop1ByPrimeOrderByIdProfileAsc(true);
        
        return setting;
    }
    
    public List<Pages> getListPages(String pageType) {
        List<Pages> pages = pageRepository.findByTypeAndActiveOrderByOrdersAsc(pageType, true); 
        
        return pages;
    }
    
}
