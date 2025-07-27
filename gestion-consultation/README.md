
# TP2 – Consultation Management System (Java Swing + DAO)

This application allows you to manage patients and their medical consultations using Java Swing and a DAO architecture.

## 🏗️ Project Architecture

The project follows a layered architecture:

```
ma.enset.gestionconsultation
├── controllers
│   ├── PatientController
│   └── ConsultationController
├── dao
│   ├── IPatientDao, IConsultationDao
│   ├── PatientDao, ConsultationDao
│   ├── DBconnection
│   └── Dao
├── entities
│   ├── Patient
│   └── Consultation
├── service
│   ├── ICabinetService
│   ├── CabinetService
│   └── ServiceTest
└── Main
```

## 🧑‍⚕️ Patient Management

### ➕ Add Patient

Adding a patient updates both:
- The patient table.
- The dropdown in the consultation tab.

![Add Patient](images/ajoutPatient.jpg)

---

### ✏️ Edit Patient

Editing a patient's details updates:
- The table view.
- The consultation dropdown via `CabinetService`.

![Edit Patient](images/modifierPatient.jpg)

---

### ❌ Delete Patient

Deleting a patient refreshes:
- The patient list.
- The dropdown in the consultation section.

![Delete Patient](images/supprimer%20Patient.jpg)

---

## 🩺 Consultation Management

### ➕ Add Consultation

You can add a consultation by selecting a patient and filling out the date and description.

![Add Consultation](images/ajouterConsultation.jpg)

---

### ✏️ Edit Consultation

Update the consultation information and associate it with another patient if needed.

![Edit Consultation](images/modifierConsultation.jpg)

---

### ❌ Delete Consultation

Delete a consultation and the list is refreshed immediately.

![Delete Consultation](images/supprmierConsultation.jpg)

---

## 🖥️ Application Interface

Tabbed interface for managing:
- Patients (add, update, delete)
- Consultations (with patient selection)

![Main Interface](images/interface.jpg)

---

## 🛠️ Technologies

- Java 17
- Swing GUI
- DAO Pattern
- JDBC (with MySQL or SQLite)

---

## 👨‍🏫 Author

Saad EL MABROUK