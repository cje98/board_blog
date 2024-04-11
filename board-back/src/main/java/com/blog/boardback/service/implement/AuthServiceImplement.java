package com.blog.boardback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.boardback.dto.request.auth.SignInRequestDto;
import com.blog.boardback.dto.request.auth.SignUpRequestDto;
import com.blog.boardback.dto.response.ResponseDto;
import com.blog.boardback.dto.response.auth.SignInResponseDto;
import com.blog.boardback.dto.response.auth.SignUpResponseDto;
import com.blog.boardback.entity.UserEntity;
import com.blog.boardback.provider.JwtProvider;
import com.blog.boardback.repository.UserRepository;
import com.blog.boardback.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

    // RequiredArgsConstructor + final : lombok이 생성자를 자동생성 해줌
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    // 내부에서 BCryptPasswordEncoder 인스턴스로 초기화되어 클래스 내부에서 의존성 주입
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

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {

        String token = null;

        try{

            String email = dto.getEmail();
            UserEntity userEntity = userRepository.findByEmail(email);
            // 없으면 로그인 실패 처리
            if (userEntity == null) return SignInResponseDto.signInFailed();

            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();
            // 비밀번호 맞는지 확인해야함.
            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if (!isMatched) return SignInResponseDto.signInFailed();

            // jwt로 인증
            token = jwtProvider.create(email);

        }catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);

    }
    
}
