package com.spring.guide.member.service;

import com.spring.guide.domain.member.Member;
import com.spring.guide.domain.member.MemberHelperService;
import com.spring.guide.member.MemberBuilder;
import com.spring.guide.member.dto.MemberProfileUpdate;
import com.spring.guide.test.MockTest;
import com.spring.guide.test.setup.request.MemberProfileUpdateBuilder;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

public class MemberProfileServiceTest extends MockTest {

    @InjectMocks
    private MemberProfileService memberProfileService;

    @Mock
    private MemberHelperService memberHelperService;

    @Test
    public void updateTest() {
        //given
        final Member member = MemberBuilder.build();
        final MemberProfileUpdate dto = MemberProfileUpdateBuilder.build();
        given(memberHelperService.findById(anyLong())).willReturn(member);

        //when
        final Member updateMember = memberProfileService.update(anyLong(), dto);


        //then
        assertThat(updateMember.getName().getFirst()).isEqualTo(dto.getName().getFirst());
        assertThat(updateMember.getName().getFullName()).isEqualTo(dto.getName().getFullName());
        assertThat(updateMember.getName().getMiddle()).isEqualTo(dto.getName().getMiddle());
        assertThat(updateMember.getName().getLast()).isEqualTo(dto.getName().getLast());
    }
}