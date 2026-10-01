package com.careerlink.profileservice.service;

import com.careerlink.profileservice.dto.ProfileRequest;
import com.careerlink.profileservice.model.Profile;
import com.careerlink.profileservice.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile createProfile(ProfileRequest request) {
        Profile profile = new Profile();
        profile.setEmail(request.getEmail());
        profile.setFullName(request.getFullName());
        profile.setPhone(request.getPhone());
        profile.setLocation(request.getLocation());
        profile.setBio(request.getBio());
        profile.setResumeUrl(request.getResumeUrl());
        return profileRepository.save(profile);
    }

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile getProfileById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found with id: " + id));
    }

    public Profile getProfileByEmail(String email) {
        return profileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found with email: " + email));
    }

    public Profile updateProfile(Long id, ProfileRequest request) {
        Profile profile = getProfileById(id);
        profile.setFullName(request.getFullName());
        profile.setPhone(request.getPhone());
        profile.setLocation(request.getLocation());
        profile.setBio(request.getBio());
        profile.setResumeUrl(request.getResumeUrl());
        return profileRepository.save(profile);
    }

    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
