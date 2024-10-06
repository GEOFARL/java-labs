package geofarl;

import java.time.LocalDate;

import enums.DayType;
import enums.LiftCountOption;
import enums.PassDuration;
import skiPass.LiftCountSkiPass;
import skiPass.SkiPass;
import skiPass.SkiPassRegistry;
import skiPass.TimeBasedSkiPass;

public class App {
    public static void main(String[] args) {
        SkiPassRegistry registry = new SkiPassRegistry();
        Turnstile turnstile = new Turnstile();

        SkiPass liftPassWorkday = new LiftCountSkiPass(DayType.WORKDAY, LiftCountOption.LIFT_10);
        SkiPass liftPassWeekend = new LiftCountSkiPass(DayType.WEEKEND, LiftCountOption.LIFT_20);
        SkiPass seasonPass = new TimeBasedSkiPass(DayType.SEASON, PassDuration.FULL_DAY, LocalDate.now().plusMonths(6));

        registry.issueSkiPass(liftPassWorkday);
        registry.issueSkiPass(liftPassWeekend);
        registry.issueSkiPass(seasonPass);

        System.out.println("Processing workday ski-pass (10 lifts):");
        for (int i = 0; i < 12; i++) {
            turnstile.processPass(liftPassWorkday);
        }

        System.out.println("\nProcessing weekend ski-pass (20 lifts):");
        for (int i = 0; i < 22; i++) {
            turnstile.processPass(liftPassWeekend);
        }

        System.out.println("\nProcessing season ski-pass:");
        for (int i = 0; i < 5; i++) {
            turnstile.processPass(seasonPass);
        }

        System.out.println("\nBlocking workday ski-pass:");
        registry.blockSkiPass(liftPassWorkday.getId());

        System.out.println("\nTrying blocked ski-pass:");
        turnstile.processPass(liftPassWorkday);

        turnstile.printSummary();
        turnstile.printBreakdownByType();
    }
}
