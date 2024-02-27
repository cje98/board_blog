package com.blog.boardback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.boardback.dto.request.auth.SignUpRequestDto;
import com.blog.boardback.dto.response.ResponseDto;
import com.blog.boardback.dto.response.auth.SignUpResponseDto;
import com.blog.boardback.entity.UserEntity;
import com.blog.boardback.repository.UserRepository;
import com.blog.boardback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 생성자 자동 생성해줌
public class AuthServiceImplement implements AuthService{

    // RequiredArgsConstructor + final : lombok이 생성자를 자동생성 해줌
    private final UserRepository userRepository;

    // 내부에서 의존성 주입할거임.
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        try{
            String email = dto.getEmail();
            boolean existedEmail = userRepository.existsByEmail(email);
            if(existedEmail) return SignUpResponseDto.duplicateEmail();

            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if(existedNickname) return SignUpResponseDto.duplicateNickname();

            String telNumber = dto.getTelNumber();
            boolean existedTelNumber = userRepository.existsByTelNumber(telNumber);
            if(existedTelNumber) return SignUpResponseDto.duplicateTelNumber();

            // 비밀번호 암호화
            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            // 생성자 만들어주기!
            // JPA Entity == 테이블 레코드
            UserEntity userEntity = new UserEntity(dto); 

            // DB에 저장
            userRepository.save(userEntity);

        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }
    
}
