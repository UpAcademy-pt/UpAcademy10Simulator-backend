INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Telem�vel",false,false,false,false,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Ve�culo",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Combust�vel",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Internet M�vel",false,false,false,false,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Via Verde",false,false,false,true,true,false);
INSERT INTO SimulationFields(name, SA, IRS, SS, TA, BE, varComponent) VALUES("Manuten��o de Ve�culo",false,false,false,true,true,false);

INSERT INTO Tax(name, value) VALUES("autonomousTributation", 10);
INSERT INTO Tax(name, value) VALUES("workerSocialSecurity", 11);
INSERT INTO Tax(name, value) VALUES("companySocialSecurity", 23.75);

INSERT INTO Margin(margin_min, margin_max) VALUES (-100, 500);

INSERT INTO WorkInsurance(workInsuranceVariable) VALUES (0.007);

--INSERT INTO FoodSubsidy(foodSubsidyMonth) VALUES(160.23);

INSERT INTO SimulationFieldsData(name, value) VALUES("marginPercentage", 0);
INSERT INTO SimulationFieldsData(name, value) VALUES("markUp", 0);
INSERT INTO SimulationFieldsData(name, value) VALUES("usagePercentage" ,0);
INSERT INTO SimulationFieldsData(name, value) VALUES("anualTotalCost",0);
INSERT INTO SimulationFieldsData(name, value) VALUES("netSalaryWithoutDuo",0);
INSERT INTO SimulationFieldsData(name, value) VALUES("netSalaryWithDuo",0);
INSERT INTO SimulationFieldsData(name, value) VALUES("grossSalary",0);
INSERT INTO SimulationFieldsData(name, value) VALUES("usagePercentage",100);
INSERT INTO SimulationFieldsData(name, value) VALUES("monthlyTotalCost",0);
INSERT INTO SimulationFieldsData(name, value) VALUES("dailyTotalCost",0);
INSERT INTO SimulationFieldsData(name, value) VALUES("hourlyTotalCost",0);
INSERT INTO SimulationFieldsData(name, value) VALUES("monthlyRate",0);
INSERT INTO SimulationFieldsData(name, value) VALUES("dailyRate",0);
INSERT INTO SimulationFieldsData(name, value) VALUES("hourlyRate",0);
