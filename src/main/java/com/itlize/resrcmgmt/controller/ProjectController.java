package com.itlize.resrcmgmt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itlize.resrcmgmt.entity.*;
import com.itlize.resrcmgmt.service.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectResourceService projectResourceService;
    @Autowired
    ProjectColumnService projectColumnService;

    @GetMapping("/project/show")
    List<Project> getAll(){
        return projectService.findAll();
    }

    @PostMapping("/project/add/{project_name}")
    void addProject(@PathVariable String project_name){
        Project project = new Project(project_name);
        List<ProjectColumn> projectColumns = new ArrayList<>();
        List<String> columns = projectColumnService.getAllColumnName();
        for(String column:columns){
            projectColumns.add(new ProjectColumn(project,column));
        }
        projectColumnService.addNewColumn(projectColumns);
        projectService.add(project);
    }

    @GetMapping("/project/search/{keyword}")
    List<Project> getAllByKeyword(@PathVariable String keyword){
        return projectService.findAllByKeyword(keyword);
    }

    @GetMapping("/project/{project_id}")
    List<Resource> getAllResourceForProject(@PathVariable int project_id){
        List<Resource> resourceList = new ArrayList<>();
        List<ProjectResource> projectResourceList = projectResourceService.getAllResourceByProjectId(project_id);
        for(ProjectResource pr:projectResourceList){
            resourceList.add(pr.getResource());
        }
        return resourceList;
    }

    @PostMapping("/project/{project_id}/add/resource")
    void addResourcesForProject(@RequestBody List<Resource> resources,@PathVariable int project_id){
        Project project = projectService.findByProjectId(project_id);
        List<ProjectResource> projectResourceList = new ArrayList<>();
        for(Resource resource:resources){
            if(!projectResourceService.isHave(project_id,resource.getResource_id()))
                projectResourceList.add(new ProjectResource(project,resource));
        }
        projectResourceService.addResourcesForProject(projectResourceList);
    }

    @DeleteMapping("/project/{project_id}/delete/resource")
    void deleteReesourceForPorject(@RequestBody List<Integer> resourceIds, @PathVariable int project_id){
        for(int resource_id:resourceIds){
            if(projectResourceService.isHave(project_id,resource_id))
                projectResourceService.deleteResourceFromProject(project_id,resource_id);
        }
    }

    @PostMapping("/project/update/{project_id}/{column_name}")
    void addValueToColumn(@RequestBody String value, @PathVariable("project_id") int project_id,@PathVariable("column_name") String column_name){
//        System.out.println(column_value);
        projectColumnService.addValue(value,project_id,column_name);
    }

    @GetMapping("/project/show/columns")

    List<ProjectColumnValue> getAllColumn(){
        List<ProjectColumnValue> projectColumnValues = new ArrayList<>();

        List<Project> projects = projectService.findAll();
        for(Project project:projects){
            int pid = project.getProject_id();
            Map<String,String> column_value = new HashMap<>();
            List<ProjectColumn> projectColumns = projectColumnService.getColumnsForProject(pid);
            for(ProjectColumn projectColumn:projectColumns){
                column_value.put(projectColumn.getColumn_name(),projectColumn.getColumn_value());
            }

           projectColumnValues.add(new ProjectColumnValue(project, column_value));
        }
        return projectColumnValues;
    }

    @PostMapping("/project/add/column/{column_name}")
    void addColumn(@PathVariable String column_name){
        List<Project> projects = projectService.findAll();
        List<ProjectColumn> projectColumns = new ArrayList<>();
        for(Project project:projects){
            projectColumns.add(new ProjectColumn(project,column_name));
        }
        projectColumnService.addNewColumn(projectColumns);
    }

    @DeleteMapping("/project/delete/column/{column_name}")
    void deleteColumn(@PathVariable String column_name){
        projectColumnService.deleteColumn(column_name);
    }

}
