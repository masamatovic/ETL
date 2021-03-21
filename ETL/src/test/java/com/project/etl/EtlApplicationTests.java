package com.project.etl;

import com.project.etl.dto.AllowanceDTO;
import com.project.etl.dto.BreakDTO;
import com.project.etl.dto.ShiftDTO;
import com.project.etl.enums.Status;
import com.project.etl.model.Allowance;
import com.project.etl.model.Break;
import com.project.etl.model.Shift;
import com.project.etl.service.TransformService;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class EtlApplicationTests {

    @Test
    void transformShift_CorrectShiftDTO_ExpectedBehavior() {
        TransformService transformService = new TransformService();
        ShiftDTO shiftDTO = new ShiftDTO(1234L, 1234L, 1234L, "2020-07-23", 1616016713144L, 1616016713144L,
                1234L, null, null, 1234L, Status.PENDING, null, 1234L, 123L,
                null, null, 1.2F, 1616016713144L, 123L, 1616016713144L);

        Shift shift = new Shift(1234L, 1234L, 1234L, "2020-07-23", "2021-03-17 16:31:53", "2021-03-17 16:31:53",
                1234L, null, null, 1234L, Status.PENDING, null, 1234L, 123L,
                null, null, 1.2F, "2021-03-17 16:31:53", 123L, "2021-03-17 16:31:53");

        Shift newShift = transformService.transformShift(shiftDTO);

        assertThat(newShift).isEqualToComparingFieldByField(shift);
    }

    @Test
    void transformShift_null_ThrowsException() {
        TransformService transformService = new TransformService();
        ShiftDTO shiftDTO = null;

        try {
            Shift newShift = transformService.transformShift(shiftDTO);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void transformBreak_CorrectBreakDTOS_ExpectedBehavior() {
        TransformService transformService = new TransformService();
        Shift shift = new Shift(1234L, 1234L, 1234L, "2020-07-23", "2021-03-17 16:31:53", "2021-03-17 16:31:53",
                1234L, null, null, 1234L, Status.PENDING, null, 1234L, 123L,
                null, null, 1.2F, "2021-03-17 16:31:53", 123L, "2021-03-17 16:31:53");
        BreakDTO breakDTO = new BreakDTO(8505l, shift.getId(), 1615924975013l, 1615925755013l, 13, true);
        BreakDTO breakDTO1 = new BreakDTO(9611l, shift.getId(), 1615943008844l, 1615943908844l, 15, false);
        ArrayList<BreakDTO> breakDTOS = new ArrayList<>();
        breakDTOS.add(breakDTO);
        breakDTOS.add(breakDTO1);
        Break break1 = new Break(8505l, "2021-03-16 15:02:55", "2021-03-16 15:15:55", 13, true, shift);
        Break break2 = new Break(9611l, "2021-03-16 20:03:28", "2021-03-16 20:18:28", 15, false, shift);

        ArrayList<Break> newBreaks = transformService.transformBreak(breakDTOS, shift);

        assertThat(break1).isEqualToComparingFieldByField(newBreaks.get(0));
        assertThat(break2).isEqualToComparingFieldByField(newBreaks.get(1));
    }

    @Test
    void transformBreak_BreakDTOSNull_ThrowsException() {
        TransformService transformService = new TransformService();
        ArrayList<BreakDTO> breakDTOS = null;
        Shift shift = new Shift(1234L, 1234L, 1234L, "2020-07-23", "2021-03-17 16:31:53", "2021-03-17 16:31:53",
                1234L, null, null, 1234L, Status.PENDING, null, 1234L, 123L,
                null, null, 1.2F, "2021-03-17 16:31:53", 123L, "2021-03-17 16:31:53");

        try {
            ArrayList<Break> newBreaks = transformService.transformBreak(breakDTOS, shift);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void transformAllowance_CorrectAllowanceDTOS_ExpectedBehavior() {
        TransformService transformService = new TransformService();
        Shift shift = new Shift(1234L, 1234L, 1234L, "2020-07-23", "2021-03-17 16:31:53", "2021-03-17 16:31:53",
                1234L, null, null, 1234L, Status.PENDING, null, 1234L, 123L,
                null, null, 1.2F, "2021-03-17 16:31:53", 123L, "2021-03-17 16:31:53");
        AllowanceDTO allowanceDTO = new AllowanceDTO(8505l, "name", 0.5f, 12.5f);
        AllowanceDTO allowanceDTO1 = new AllowanceDTO(9611l, "name1", 9.5f, 14.5f);
        ArrayList<AllowanceDTO> allowanceDTOS = new ArrayList<>();
        allowanceDTOS.add(allowanceDTO);
        allowanceDTOS.add(allowanceDTO1);
        Allowance allowance1 = new Allowance(8505l, "name", 0.5f, 12.5f, shift);
        Allowance allowance2 = new Allowance(9611l, "name1", 9.5f, 14.5f, shift);

        ArrayList<Allowance> allowances = transformService.transformAllowance(allowanceDTOS, shift);

        assertThat(allowance1).isEqualToComparingFieldByField(allowances.get(0));
        assertThat(allowance2).isEqualToComparingFieldByField(allowances.get(1));
    }
    @Test
    void transformAllowance_AllowanceDTOSNull_ThrowsException() {
        TransformService transformService = new TransformService();
        ArrayList<AllowanceDTO> allowanceDTOS = null;
        Shift shift = new Shift(1234L, 1234L, 1234L, "2020-07-23", "2021-03-17 16:31:53", "2021-03-17 16:31:53",
                1234L, null, null, 1234L, Status.PENDING, null, 1234L, 123L,
                null, null, 1.2F, "2021-03-17 16:31:53", 123L, "2021-03-17 16:31:53");
        try {
            ArrayList<Allowance> newBreaks = transformService.transformAllowance(allowanceDTOS, shift);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

}