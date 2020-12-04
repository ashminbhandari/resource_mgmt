package com.resource_mgmt.resource_mgmt.controller;


import com.resource_mgmt.resource_mgmt.model.Project;
import com.resource_mgmt.resource_mgmt.model.ProjectResource;
import com.resource_mgmt.resource_mgmt.model.Resource;
import com.resource_mgmt.resource_mgmt.service.ProjectResourceServiceImpl;
import com.resource_mgmt.resource_mgmt.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    ProjectServiceImpl projectService;
    @Autowired
    ProjectResourceServiceImpl projectResourceService;

    @GetMapping("/projects")
    List<Project> getAll(){
        return projectService.findAll();
    }

    @GetMapping("/project/search/{keyword}")
    List<Project> getAllByKeyword(@PathVariable String keyword){
        return projectService.findAllByKeyword(keyword);
    }

    @GetMapping("/project/{id}")
    List<Resource> getAllResourceForProject(@PathVariable int id){
        List<Resource> resourceList = new ArrayList<>();
        List<ProjectResource> projectResourceList = projectResourceService.getAllResourceByProjectId(id);
        for(ProjectResource pr:projectResourceList){
            resourceList.add(pr.getResource());
        }
        return resourceList;
    }

    @PostMapping("/project/addResource/{project_id}")
    void addResourcesForProject(@RequestBody List<Resource> resources,@PathVariable int project_id){
        Project project = projectService.findByProjectId(project_id);
        List<ProjectResource> projectResourceList = new ArrayList<>();
        for(Resource resource:resources){
            projectResourceList.add(new ProjectResource(project,resource));
        }
        projectResourceService.addResourcesForProject(projectResourceList);
    }

    @DeleteMapping("/project/delete/{project_id}")
    void deleteReesourceForPorject(@RequestBody List<Resource> resources, @PathVariable int project_id){
        for(Resource resource:resources){
            projectResourceService.deleteResourceFromProject(project_id,resource.getResource_id());
        }
    }

}
