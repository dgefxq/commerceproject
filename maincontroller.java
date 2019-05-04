package sample9.demo9;

import sample9.demo9.userdata;
import sample9.demo9.SecurityService;
import sample9.demo9.userservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.lang.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Controller
public class maincontroller {

    public int uiui = 2;

    @Autowired
    private transactionservice transactionservice;
    @Autowired
    private goalservice goalservice;
    @Autowired
    private userservice userservice;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/userpage")
    public String userGet(Model model, @Valid goaldata goaldata) {

        double zero = 0;

        // used to display counts for the tabs on userpage.html
        int countall = goalservice.countall();
        int countcurrent = goalservice.countcurrent();
        int countachieved = goalservice.countachieved();
        int countmissed = goalservice.countmissed();

        Double goalrewardamount = goalservice.goalreward();
        List<Double> goalbegingraph = new ArrayList<Double>(); // initial value?
        List<Double> goalgraph = new ArrayList<Double>(); // end value?
        List<Double> currentgraph = new ArrayList<Double>(); // current value?
        List<String> goalpercent = new ArrayList<String>(); // percentage completed?
        List<Double> totalgraph = new ArrayList<Double>(); // no idea

        List<Integer> goalrewardindex = goalservice.goalrewardindex();
        List<Integer> goalrewarduserindex = goalservice.goalrewarduserindex();

        List<Double> crlist = goalservice.crlist();
        List<Double> drlist = goalservice.drlist();
        List<Date> crdate = goalservice.crdate();
        List<Date> drdate = goalservice.drdate();
        List<Double> withdrawlaltemp = goalservice.withdrawlaltemp();
        List<Integer> drindex = goalservice.drindex();
        List<Integer> allindex = goalservice.allindex();

        List<Double> allwithdrawal = new ArrayList<Double>();
        List<Integer> crindexnew = new ArrayList<Integer>();
        List<Integer> drindexnew = new ArrayList<Integer>();
        List<Integer> crbalanceindexnew = new ArrayList<Integer>();
        List<Integer> drbalanceindexnew = new ArrayList<Integer>();
        List<Integer> beginbalanceindexnew = new ArrayList<Integer>();

        List<Double> deposittemp = goalservice.deposittemp();
        List<Integer> crindex = goalservice.crindex();

        List<Double> alldeposit = new ArrayList<Double>();

        List<Double> beginbalancetemp = goalservice.beginbalancetemp();
        List<Double> crbalancetemp = goalservice.crbalancetemp();
        List<Double> drbalancetemp = goalservice.drbalancetemp();
        List<Integer> crbalanceindex = goalservice.crbalanceindex();
        List<Integer> drbalanceindex = goalservice.drbalanceindex();
        List<Integer> beginbalanceindex = goalservice.beginbalanceindex();
        List<Double> beginbalance = new ArrayList<Double>();
        List<Double> allbalance = new ArrayList<Double>();
        List<Double> crbalance = new ArrayList<Double>();
        List<Double> drbalance = new ArrayList<Double>();

        List<String> findgoaltype = goalservice.setFindgoaltype();
        List<String> findaccounttype = goalservice.setFindaccounttype();
        List<String> findgoalstatus = goalservice.findgoalstatus();
        List<String> allgoaltitle = goalservice.allgoaltitle();
        List<String> allgoalnote = goalservice.allgoalnote();

        List<Date> allcreatedate = goalservice.allcreatedate();
        List<Date> findduedate = goalservice.findduedate();
        List<Date> findcreatedate = goalservice.findcreatedate();

        List<transactiondata> detailtransaction = transactionservice.detailtransaction();

        List<Double> goalamount = goalservice.setGoalamount();
        List<Double> goalfinal = new ArrayList<Double>();
        List<Double> goalgo = new ArrayList<Double>();
        List<Double> finalbalance = new ArrayList<Double>();

        DecimalFormat df = new DecimalFormat(".##");
        DecimalFormat dfpercent = new DecimalFormat(".");
        List<String> dfgoalfinal = new ArrayList<String>();
        List<String> dfgoalgo = new ArrayList<String>();
        List<String> dffinalbalance = new ArrayList<String>();
        List<String> dfcurrentgraph = new ArrayList<String>();
        List<String> dftotalgraph = new ArrayList<String>();

        LocalDate localDate = LocalDate.now();
        Date today = java.sql.Date.valueOf(localDate);

        for (int index = 0; index < goalamount.size(); index++) {
            allwithdrawal.add((double) 0);
            alldeposit.add((double) 0);
            beginbalance.add((double) 0);
            crbalance.add((double) 0);
            drbalance.add((double) 0);
            allbalance.add((double) 0);
        }

        for (int index2 = 0; index2 < drindex.size(); index2++) {
            drindexnew.add(allindex.indexOf(drindex.get(index2)));
            allwithdrawal.set(drindexnew.get(index2), withdrawlaltemp.get(index2));
        }

        for (int index2 = 0; index2 < crindex.size(); index2++) {
            crindexnew.add(allindex.indexOf(crindex.get(index2)));
            alldeposit.set(crindexnew.get(index2), deposittemp.get(index2));
        }

        for (int index2 = 0; index2 < beginbalanceindex.size(); index2++) {
            beginbalanceindexnew.add(allindex.indexOf(beginbalanceindex.get(index2)));
            beginbalance.set(beginbalanceindexnew.get(index2), beginbalancetemp.get(index2));
        }

        for (int index2 = 0; index2 < crbalanceindex.size(); index2++) {
            crbalanceindexnew.add(allindex.indexOf(crbalanceindex.get(index2)));
            crbalance.set(crbalanceindexnew.get(index2), crbalancetemp.get(index2));
        }

        for (int index2 = 0; index2 < drbalanceindex.size(); index2++) {
            drbalanceindexnew.add(allindex.indexOf(drbalanceindex.get(index2)));
            drbalance.set(drbalanceindexnew.get(index2), drbalancetemp.get(index2));
        }

        for (int index2 = 0; index2 < goalamount.size(); index2++) {
            allbalance.set(beginbalanceindexnew.get(index2),
                    (beginbalance.get(index2) + crbalance.get(index2) - drbalance.get(index2)));

        }

        SimpleDateFormat datefm = new SimpleDateFormat("MM/dd/yyyy");
        List<String> createdategraph = new ArrayList<String>();
        List<String> duedategraph = new ArrayList<String>();

        for (int index = 0; index < goalamount.size(); index++) {
            if (findgoaltype.get(index).contentEquals("Balance")) {
                if (findaccounttype.get(index).contentEquals("Credit Card")) {
                    goalfinal.add(-alldeposit.get(index) + allwithdrawal.get(index) + allbalance.get(index));
                } else {
                    goalfinal.add(alldeposit.get(index) - allwithdrawal.get(index) + allbalance.get(index));
                }
            }
            if (findgoaltype.get(index).contentEquals("Deposit+Withdrawal")) {
                goalfinal.add(alldeposit.get(index) + allwithdrawal.get(index));
            }
            if (findgoaltype.get(index).contentEquals("Deposit-Withdrawal")) {
                goalfinal.add(alldeposit.get(index) - allwithdrawal.get(index));
            }
            if (findgoaltype.get(index).contentEquals("Deposit")) {
                goalfinal.add(alldeposit.get(index));
            }
            if (findgoaltype.get(index).contentEquals("Withdrawal")) {
                goalfinal.add(allwithdrawal.get(index));
            }

            goalgo.add(goalamount.get(index) - goalfinal.get(index));
            finalbalance.add(alldeposit.get(index) - allwithdrawal.get(index) + allbalance.get(index));
            dfgoalfinal.add("$" + df.format(goalfinal.get(index)));
            dfgoalgo.add("$" + df.format(goalgo.get(index)));
            dffinalbalance.add("$" + df.format(finalbalance.get(index)));

            if (findgoalstatus.get(index).contentEquals("processing")) {
                if (findduedate.get(index).before(today)) {
                    if (goalgo.get(index) > 0) {
                        goaldata = goalservice.findOne(allindex.get(index));
                        goalservice.missedupdate(goaldata);
                    } else {
                        goaldata = goalservice.findOne(allindex.get(index));
                        goalservice.achievedupdate(goaldata);
                    }
                }
                if (findduedate.get(index).after(today) || findduedate.get(index).equals(today)) {
                    if (goalgo.get(index) <= 0) {
                        goaldata = goalservice.findOne(allindex.get(index));
                        goalservice.achievedupdate(goaldata);
                    }
                }
            }

            if (findgoaltype.get(index).contentEquals("Balance")) {
                goalbegingraph.add(allbalance.get(index));
            } else {
                goalbegingraph.add((double) 0);
            }

            goalgraph.add(goalbegingraph.get(index) - goalfinal.get(index));

            if (goalfinal.get(index) >= goalbegingraph.get(index)) {
                currentgraph.add(Math.abs(goalgraph.get(index)));
            } else {
                currentgraph.add((double) 0);
            }

            if (findgoalstatus.get(index).contentEquals("achieved")) {
                currentgraph.set(index, (double) 100);
                goalgo.set(index, (double) 0);
            }

            dfcurrentgraph.add(df.format(currentgraph.get(index)));
            goalpercent.add(
                    dfpercent.format(currentgraph.get(index) / (goalgo.get(index) + currentgraph.get(index)) * 100));
            totalgraph.add(currentgraph.get(index) + goalgo.get(index));
            createdategraph.add(datefm.format(findcreatedate.get(index)));
            duedategraph.add(datefm.format(findduedate.get(index)));
            dftotalgraph.add(df.format(totalgraph.get(index)));
        }
        int unique = goalservice.uniquerewardindex();
        /*
         * 
         * 
         * for(int index2=0; index2<balanceindex.size(); index2++){
         * 
         * 
         * allbalance.set(balanceindex.get(index2)-1, balancetemp.get(index2));
         * 
         * 
         * }
         * 
         */

        model.addAttribute("findgoalstatus", findgoalstatus);
        model.addAttribute("unique", unique);
        model.addAttribute("goalfinal", dfgoalfinal);
        model.addAttribute("goalgo", dfgoalgo);
        model.addAttribute("goalamount", goalamount);
        model.addAttribute("findgoaltype", findgoaltype);
        model.addAttribute("findaccounttype", findaccounttype);
        model.addAttribute("findduedate", findduedate);
        model.addAttribute("finalbalance", dffinalbalance);
        model.addAttribute("detailtransaction", detailtransaction);
        model.addAttribute("withdrawlaltemp", withdrawlaltemp);
        model.addAttribute("drindex", drindex);
        model.addAttribute("allwithdrawal", allwithdrawal);
        model.addAttribute("alldeposit", alldeposit);
        model.addAttribute("allbalance", allbalance);
        model.addAttribute("crbalance", crbalance);
        model.addAttribute("beginbalance", beginbalance);
        model.addAttribute("drbalance", drbalance);
        model.addAttribute("goalrewardindex", goalrewardindex);
        model.addAttribute("goalrewarduserindex", goalrewarduserindex);
        model.addAttribute("crbalancetemp", deposittemp);
        model.addAttribute("crbalanceindex", crbalanceindex);
        model.addAttribute("allgoaltitle", allgoaltitle);
        model.addAttribute("allgoalnote", allgoalnote);
        model.addAttribute("allcreatedate", allcreatedate);
        model.addAttribute("allindex", allindex);
        model.addAttribute("goalrewardamount", goalrewardamount);
        model.addAttribute("crtest", crindex);
        model.addAttribute("countall", countall);
        model.addAttribute("countcurrent", countcurrent);
        model.addAttribute("countachieved", countachieved);
        model.addAttribute("countmissed", countmissed);
        model.addAttribute("goalbegingraph", goalbegingraph);
        model.addAttribute("goalgraph", goalgraph);
        model.addAttribute("currentgraph", currentgraph);
        model.addAttribute("crlist", crlist);
        model.addAttribute("drlist", drlist);
        model.addAttribute("crdate", crdate);
        model.addAttribute("drdate", drdate);

        // changes made here - Daniel Ewing 4/26/19
        /*
         * the following loop provides data to userpage.html file in order to generate
         * goal tracking graffics
         */

        for (int i = 0; i < countall; i++) {
            String iterString = Integer.toString(i + 1);
            model.addAttribute(("currentgraph" + iterString), dfcurrentgraph.get(i));
            model.addAttribute(("goalgograph" + iterString), goalgo.get(i));
            model.addAttribute(("goalpercent" + iterString), goalpercent.get(i));
            model.addAttribute(("goaltitle" + iterString), allgoaltitle.get(i));
            model.addAttribute(("goalamount" + iterString), goalamount.get(i));
            model.addAttribute(("totalgraph" + iterString), dftotalgraph.get(i));
            model.addAttribute(("goalstatus" + iterString), findgoalstatus.get(i));
            model.addAttribute(("goaltype" + iterString), findgoaltype.get(i));
            model.addAttribute(("createdate" + iterString), createdategraph.get(i));
            model.addAttribute(("duedate" + iterString), duedategraph.get(i));
            model.addAttribute(("accountype" + iterString), findaccounttype.get(i));
            model.addAttribute(("goalnote" + iterString), allgoalnote.get(i));
        }
        // working on query for current graph. CGT meants "Current Goals Tab" as of now
        // this just reprints the first two graphs.
        for (int i = 0; i < countcurrent; i++) {
            String iterString = Integer.toString(i + 1);
            model.addAttribute(("currentgraphCGT" + iterString), dfcurrentgraph.get(i));
            model.addAttribute(("goalgographCGT" + iterString), goalgo.get(i));
            model.addAttribute(("goalpercentCGT" + iterString), goalpercent.get(i));
            model.addAttribute(("goaltitleCGT" + iterString), allgoaltitle.get(i));
            model.addAttribute(("goalamountCGT" + iterString), goalamount.get(i));
            model.addAttribute(("totalgraphCGT" + iterString), dftotalgraph.get(i));
            model.addAttribute(("goalstatusCGT" + iterString), findgoalstatus.get(i));
            model.addAttribute(("goaltypeCGT" + iterString), findgoaltype.get(i));
            model.addAttribute(("createdateCGT" + iterString), createdategraph.get(i));
            model.addAttribute(("duedateCGT" + iterString), duedategraph.get(i));
            model.addAttribute(("accountypeCGT" + iterString), findaccounttype.get(i));
            model.addAttribute(("goalnoteCGT" + iterString), allgoalnote.get(i));
        }

        // changes end - Daniel Ewing 4/26/19
        return "userpage";
    }

    @PostMapping("/userpage")
    public String userPost(Model model) {
        return "redirect:/userpage";
    }

    @RequestMapping(value = "/savereward", method = RequestMethod.POST)
    public String savereward(@Valid transactiondata transactiondata, @Valid goaldata goaldata, BindingResult result,
            ModelMap model, RedirectAttributes redirectAttributes) {
        if (goalservice.goalrewardstatus().contentEquals("achieved")) {
            redirectAttributes.addFlashAttribute("note",
                    "Congratulations! Reward Accepted! The Reward Amount Was Sent To Your Checking Account!");
            goaldata = goalservice.findOne(goalservice.uniquerewardindex());
            transactionservice.savereward(transactiondata);
            goalservice.changerewardstatus(goaldata);

        } else if (goalservice.goalrewardstatus().contentEquals("rewarded")) {
            redirectAttributes.addFlashAttribute("note", "Your Reward Was Already Accepted!");
        } else if (goalservice.goalrewardstatus().contentEquals("missed")) {
            redirectAttributes.addFlashAttribute("note", "You Missed This Reward!");
        } else {
            redirectAttributes.addFlashAttribute("note", "You Have Not Yet Earned A Reward! Please Try Again Later!");
        }
        return "redirect:/userpage";
    }

    @RequestMapping("/loginsucess")
    public String helloAdmin() {
        return "loginsucess";
    }

    @GetMapping("/loginpage")
    public String LoginpageGet(Model model) {
        model.addAttribute("loginpage", new userdata());
        return "loginpage";
    }

    @RequestMapping(value = { "/loginpage" })
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        return model;
    }

    @RequestMapping(value = "/savegoal", method = RequestMethod.POST)
    public String savegoal(@Valid goaldata goaldata, BindingResult result, ModelMap model,
            RedirectAttributes redirectAttributes) {
        goalservice.savegoal(goaldata);
        redirectAttributes.addFlashAttribute("notenewgoal", "New Goal was Created Success");
        return "redirect:/userpage";
    }

    @RequestMapping(value = "/savegoaladmin", method = RequestMethod.POST)
    public String savegoaladmin(@Valid goaldata goaldata, BindingResult result, ModelMap model,
            RedirectAttributes redirectAttributes) {
        goalservice.savegoaladmin(goaldata);
        redirectAttributes.addFlashAttribute("note", "New Goal was Created Success");
        return "redirect:/creategoaladmin";
    }

    @RequestMapping(value = "/deletegoal/{id}", method = RequestMethod.GET)
    public ModelAndView deletegoal(@PathVariable int id) {
        goaldata goaldata = goalservice.findOne(id);
        goalservice.deletegoal(goaldata);
        return new ModelAndView("redirect:/showgoalpage");
    }

    @RequestMapping(value = "/showgoalpage", method = RequestMethod.GET)
    public String showgoalp(Model model) {
        List<goaldata> showgoal = goalservice.findAll();
        model.addAttribute("showgoal", showgoal);
        return "showgoalpage";
    }

    @RequestMapping(value = "/showalluser", method = RequestMethod.GET)
    public String showalluser(Model model) {
        List<userdata> showalluser = userservice.findAll();
        model.addAttribute("showalluser", showalluser);
        return "showalluser";
    }

    @RequestMapping(value = "/creategoaladmin", method = RequestMethod.GET)
    public String goalcreatedpageadmin(ModelMap model) {
        goaldata goaldata = new goaldata();
        model.addAttribute("goaldata", goaldata);
        LocalDate today = LocalDate.now();
        model.addAttribute("today", today);
        return "creategoaladmin";
    }

    @RequestMapping(value = "/creategoalpage", method = RequestMethod.GET)
    public String goalcreatedpage(ModelMap model) {
        goaldata goaldata = new goaldata();
        model.addAttribute("goaldata", goaldata);
        LocalDate today = LocalDate.now();
        model.addAttribute("today", today);
        return "creategoalpage";
    }

    @RequestMapping(value = "/savetransaction", method = RequestMethod.POST)
    public String savetransaction(@Valid transactiondata transactiondata, BindingResult result, ModelMap model,
            RedirectAttributes redirectAttributes) {
        transactionservice.savetransaction(transactiondata);
        redirectAttributes.addFlashAttribute("note", "New Transaction had been added");
        return "redirect:/addtransactionpage";
    }

    @RequestMapping(value = "/deletetransaction/{id}", method = RequestMethod.GET)
    public ModelAndView deletetransaction(@PathVariable int id) {
        transactiondata transactiondata = transactionservice.findOne(id);
        transactionservice.deletetransaction(transactiondata);
        return new ModelAndView("redirect:/showtransactionpage");
    }

    @RequestMapping(value = "/showtransactionpage", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<transactiondata> showtransaction = transactionservice.findAll();
        model.addAttribute("showtransaction", showtransaction);
        return "showtransactionpage";
    }

    @RequestMapping(value = "/addtransactionpage", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        transactiondata transactiondata = new transactiondata();
        model.addAttribute("transactiondata", transactiondata);
        LocalDate today = LocalDate.now();
        model.addAttribute("today", today);
        return "addtransactionpage";
    }

    @RequestMapping(value = "/saveuser", method = RequestMethod.POST)
    public String saveuser(@ModelAttribute("userdata") @Valid userdata userdata, BindingResult result, ModelMap model,
            RedirectAttributes redirectAttributes) {
        userdata.setPassword(passwordEncoder.encode(userdata.getPassword()));
        userservice.saveuser(userdata);
        redirectAttributes.addFlashAttribute("note", "Sign Up Success");
        return "redirect:/signuppage";
    }

    @RequestMapping(value = "/signuppage", method = RequestMethod.GET)
    public String signup(ModelMap model) {
        userdata userdata = new userdata();
        model.addAttribute("userdata", userdata);

        return "signuppage";
    }

    @ModelAttribute("goaltypeshort")
    public List<String> goaltypeshort() {
        List<String> goaltypeshort = new ArrayList<String>();
        goaltypeshort.add("Deposit");
        goaltypeshort.add("Withdrawal");
        goaltypeshort.add("Deposit+Withdrawal");
        goaltypeshort.add("Deposit-Withdrawal");
        goaltypeshort.add("Balance");
        return goaltypeshort;
    }

    @ModelAttribute("typeshort")
    public List<String> typeshort() {
        List<String> typeshort = new ArrayList<String>();
        typeshort.add("Checking");
        typeshort.add("Savings");
        typeshort.add("Credit Card");
        return typeshort;
    }

    @ModelAttribute("crdrshort")
    public List<String> crdrshort() {
        List<String> crdrshort = new ArrayList<String>();
        crdrshort.add("CR");
        crdrshort.add("DR");
        return crdrshort;
    }
}
