package com.icm.dateroapi.Services;

import com.icm.dateroapi.Models.BusesModel;
import com.icm.dateroapi.Models.EmpresasModel;
import com.icm.dateroapi.Repositories.BusesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusesService {
    @Autowired
    BusesRepository busesRepository;
    public List<BusesModel> GetAll(){
        return busesRepository.findAll();
    }

    public Optional<BusesModel> GetById(Long id){
        return busesRepository.findById(id);
    }

    public List<BusesModel> getByEmpresa(Long empresaid) {
        return busesRepository.findByEmpresasModelId(empresaid);
    }

    public List<BusesModel> getByEmpresaAndEstado(Long empresaid, Boolean estado) {
        return busesRepository.findByEmpresasModelIdAndEstado(empresaid, estado);
    }

    public BusesModel CreateBus(BusesModel busesModel){
        return busesRepository.save(busesModel);
    }

    public BusesModel EditBus(BusesModel busesModel, Long id){
        Optional<BusesModel> existing = busesRepository.findById(id);
        if (existing.isPresent()){
            BusesModel bus = existing.get();
            bus.setModelo(busesModel.getModelo());
            bus.setPlaca(busesModel.getPlaca());
            bus.setEstado(busesModel.getEstado());
            bus.setUsuariosModel(busesModel.getUsuariosModel());
            bus.setEmpresasModel(busesModel.getEmpresasModel());
            bus.setRutasModel(busesModel.getRutasModel());
            return busesRepository.save(bus);
        }
        return null;
    }

    public BusesModel EditarPosicionamiento(BusesModel busesModel, Long id){
        Optional<BusesModel> existing = busesRepository.findById(id);
        if (existing.isPresent()){
            BusesModel bus = existing.get();
            bus.setLongitud(busesModel.getLongitud());
            bus.setLatitud(busesModel.getLatitud());
            return busesRepository.save(bus);
        }
        return null;
    }

    public void DeleteBus(Long id){
        busesRepository.deleteById(id);
    }
}