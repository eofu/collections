package com.myself.pattern.structural.structural5composite.organizational;

public class CompositeClient {
    public void listOrgInfo() {
        OrganizationComponent org = constructOrganization();
        System.out.printf("%s共有%d名员工%n", org.getName(), org.getStaffCount());
        
        OrganizationComponent subOrg = org.getChild("分公司IT部");
        System.out.printf("%s共有%d名员工%n", subOrg.getName(), subOrg.getStaffCount());
    }
    
    private OrganizationComponent constructOrganization() {
        // 构建总部
        OrganizationComposite head = new OrganizationComposite("总公司");
        AdminDepartment headAdmin = new AdminDepartment("总公司行政部");
        ItDepartment headIt = new ItDepartment("总公司IT部");
        head.add(headAdmin);
        head.add(headIt);
        
        // 构建分公司
        OrganizationComposite head1 = new OrganizationComposite("分公司");
        AdminDepartment headAdmin1 = new AdminDepartment("分公司行政部");
        ItDepartment headIt1 = new ItDepartment("分公司IT部");
        head1.add(headAdmin1);
        head1.add(headIt1);
        
        // 将分公司加入到head中
        head.add(head1);
        
        return head;
    }
}
