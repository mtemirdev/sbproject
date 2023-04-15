package com.mouflon.api;

import com.mouflon.dto.request.GroupRequest;
import com.mouflon.dto.response.GroupResponse;
import com.mouflon.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/groups")
@PreAuthorize("hasAnyAuthority('ADMIN', 'TEACHER')")
public class GroupApi {

    private final GroupService groupService;

    @PostMapping("/create_group")
    public String createGroup(@RequestBody GroupRequest groupRequest) {
        groupService.createGroup(groupRequest);
        return "Group successfully created!";
    }

    @GetMapping("/get_all_groups")
    public List<GroupResponse> getAllGroups() {
        return groupService.findAllGroups();
    }

    @GetMapping("/get_group/{id}")
    public GroupResponse getById(@PathVariable Long id) {
        return groupService.findGroupById(id);
    }

    @DeleteMapping("/delete_group/{id}")
    public String deleteById(@PathVariable Long id) {
        groupService.deleteGroupById(id);
        return "Group successfully deleted!";
    }

    @PutMapping("/update_group/{id}")
    public String updateById(@PathVariable Long id, @RequestBody GroupRequest groupRequest) {
        groupService.updateGroup(id, groupRequest);
        return "Company successfully updated!";
    }
}
